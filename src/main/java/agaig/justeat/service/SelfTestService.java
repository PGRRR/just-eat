package agaig.justeat.service;

import agaig.justeat.repository.SelfTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelfTestService { //service는 프레젠테이션(뷰)에서 직접 엔티티에 접근하지 않고, 비즈니스 로직을 처리할 수 있도록하는 계층
                               //Repository에 정의된 비즈니스 로직을 처리하거나 직접 엔티티에 접근
    private final SelfTestRepository selfTestRepository;

    @Autowired //필요한 의존 객체의 타입에 해당하는 빈을 찾아 주입
    public SelfTestService(SelfTestRepository selfTestRepository) {this.selfTestRepository = selfTestRepository;}

}

    //비즈니스 로직이란 업무에 필요한 데이터처리를 수행하는 응용프로그램의 일부

