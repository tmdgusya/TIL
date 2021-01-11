import java.util.Random;

public class VideoDataArchitecture {

    private Video last = null;
    private Video first = null;
    private int size = 1;
    private int sumOfPlayTime = 0;

    public void add(Video video){
        ifNotExistLastThenAddLastVideo(video);
        ifNotExistFirstThenAddFirstVideo(video);
        last = video;
        video.setIndex(size);
        currentListPrinter();
        size++;
    }


    public void insert(Video video, int index){
        if(!indexBiggerThanSize(video, index)){
            Video indexVideo = findIndexVideo(index);
            video.setIndex(indexVideo.getIndex());
            Video indexPreviousVideo = indexVideo.getPrevious();
            indexVideo.setPrevious(video);
            if(indexPreviousVideo != null){
                indexPreviousVideo.setNext(video);
            }
            video.setNext(indexVideo);
            if(indexVideo == first){
                first = video;
            }
            fixIndex(indexVideo);
            size++;
        }
    }

    private boolean indexBiggerThanSize(Video video, int index) {
        if(index > size){
            this.add(video);
            return true;
        }
        return false;
    }

    public void delete(Video video){
        Video nextVideo = null;
        Video previousVideo = null;

        ifSizeIsNullThrowError();

        if(isExistPreviousVideo(video) != null)
            isExistPreviousVideo(video).setNext(nextVideo);

        if(isExistNextVideo(video) != null){
            isExistNextVideo(video).setPrevious(previousVideo);
            isExistNextVideo(video).setIndex(video.getIndex());
            fixIndex(nextVideo);
        }

        video = null; // 객체 참조 해제
        size--;
        currentListPrinter();
    }

    private void ifSizeIsNullThrowError() {
        if(size == 0){
            throw new IllegalArgumentException("비디오 큐에 비디오가 없습니다.");
        }
    }


    public void render(){
        Video saveFirst = first;
        while(first != null){
            Video next = first.getNext();
            sumOfPlayTime += first.getPlayTime();
            first = next;
        }
        first = saveFirst;
        System.out.println("영상클립 : " + size);
        System.out.println("전체길이 : " + sumOfPlayTime + "sec");
    }

    public void print(){
        Video saveFirst = first;
        System.out.println("---영상클립---");
        while(first != null){
            Video next = first.getNext();
            System.out.println(first.toString());
            System.out.println(first.getIndex());
            first = next;
        }
        first = saveFirst;
    }

    private Video findIndexVideo(int index){
        Video saveFirst = first;
        Video video = null;
        while(first != null){
            Video next = first.getNext();
            if(first.getIndex() == index){
                video = first;
            }
            first = next;
        }
        first = saveFirst;
        return video;
    }

    private void fixIndex(Video video){
        Video videos = video;
        while(videos != null){
            Video next = videos.getNext();
            int index = videos.getIndex();
            ++index;
            videos.setIndex(index);
            videos = next;
        }
    }


    private void ifNotExistFirstThenAddFirstVideo(Video video) {
        if(first == null){
            first = video;
        }
    }

    private void ifNotExistLastThenAddLastVideo(Video video) {
        if(last != null){
            video.setPrevious(last);
            last.setNext(video);
        }
    }

    private void currentListPrinter(){
        Video saveFirst = first;
        System.out.print("|---");
        while(first != null){
            Video next = first.getNext();
            System.out.print(first.addTime());
            System.out.print("---");
            first = next;
        }
        System.out.print("[end]");
        System.out.println();
        first = saveFirst;
    }


    private Video isExistNextVideo(Video video) {
        if(video.getNext() != null){
            if(video == first){
                first = video.getNext();
            }
            return video.getNext();
        }
        return null;
    }

    private Video isExistPreviousVideo(Video video) {
        if(video.getPrevious() != null){
            if(last == video){
                last = video.getPrevious();
            }
            return video.getPrevious();
        }
        return null;
    }

//    private String autoGenerationId(){
//        Random random = new Random();
//    }

    public int getSize() {
        return size;
    }

}
