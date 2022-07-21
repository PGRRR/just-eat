//package agaig.justeat.repository;
//
//import agaig.justeat.member.domain.Information;
//import agaig.justeat.dto.InfoBoardResponseDto;
//import agaig.justeat.dto.InfoSaveRequestDto;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class InformationRepositoryTest {
//
//    @Autowired
//    InformationRepository informationRepository;
//
//    @Test
//    void 조회수증가() {
//        informationRepository.deleteAll();
//        assertEquals(0, informationRepository.count());
//
//        // given
//        Information information = new Information();
//        information.setTitle("test title");
//        information.setContent("test content");
//        information.setWriter("tester");
//        InfoSaveRequestDto requestDto = new InfoSaveRequestDto(information);
//
//        // when
//        // then
//        assertEquals(InformationMapper.xml, informationRepository.insert(requestDto.toEntity()));
//        assertEquals(InformationMapper.xml, informationRepository.count());
//    }
//}