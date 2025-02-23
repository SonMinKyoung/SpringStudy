package study.mini02.order;

//import study.mini02.discount.DiscountPolicy;
//import study.mini02.discount.FixDiscountPolicy;
import study.mini02.discount.DiscountPolicy;
import study.mini02.member.Member;
import study.mini02.member.MemberRepository;
import study.mini02.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private DiscountPolicy discountPolicy; //nullpointException 발생한다.
    private MemberRepository memberRepository;

    public OrderServiceImpl(MemberRepository memberRepository,DiscountPolicy discountPolicy){
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
