package hello.member;

public class MemberServiceImpl implements MemberService{

    MemberRepository memberRepository = new MemoryMemberRepository();
//
//    public MemberServiceImpl(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMemeber(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
