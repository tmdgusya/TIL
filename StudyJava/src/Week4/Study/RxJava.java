package Week4.Study;

import rx.Observable;
import rx.Subscriber;

public class RxJava {

    static Observable<String> myObservable = Observable.create(new Observable.OnSubscribe<String>() {
        @Override
        public void call(Subscriber<? super String> subscriber) {
            subscriber.onNext("Hello, RxJava");
            subscriber.onCompleted();
        }
    });

    static Subscriber<String> subscriber = new Subscriber<String>() {
        @Override
        public void onCompleted() {
            System.out.println("finish");
        }

        @Override
        public void onError(Throwable throwable) {
            throwable.printStackTrace();
        }

        @Override
        public void onNext(String s) {
            System.out.println(s);
        }
    };

    public static void main(String[] args) {
        myObservable.subscribe(subscriber);
    }
}
