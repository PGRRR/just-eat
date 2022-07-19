package agaig.justeat.repository;

import agaig.justeat.domain.Information;
import agaig.justeat.dto.InfoSaveRequestDto;
import agaig.justeat.dto.InfoUpdateRequestDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface InformationRepository {

    Information select(Long info_id);

    Long insert(Information information);

    Long update(Information information);

    Long insert(InfoSaveRequestDto saveRequestDto);

    Long update(InfoUpdateRequestDto updateRequestDto);

    Long delete(Long info_id, Long member_id);

    List<Information> selectAll();

    List<Information> selectPage(Map<String, Integer> map);

    Integer count();

    Long increaseViewCnt(Long info_id);

    Long deleteAll();
}
