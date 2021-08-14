package dogood.hackathon.navi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dogood.hackathon.navi.domain.entity.ScreenShotCommentEntity;
import dogood.hackathon.navi.domain.entity.ScreenShotEntity;
import dogood.hackathon.navi.domain.entity.ScreenShotImgEntity;
import dogood.hackathon.navi.domain.repository.ScreenShotCommentRepository;
import dogood.hackathon.navi.domain.repository.ScreenShotImgRepository;
import dogood.hackathon.navi.domain.repository.ScreenShotRepository;
import dogood.hackathon.navi.dto.ScreenShotCommentDto;
import dogood.hackathon.navi.dto.ScreenShotDto;
import dogood.hackathon.navi.dto.ScreenShotImgDto;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ScreenShotDetailService {

	private ScreenShotRepository screenShotRepository;
	private ScreenShotCommentRepository screenShotCommentRepository;
	private ScreenShotImgRepository screenShotImgRepository;
	
	@Transactional
	public ScreenShotDto getScreenShotDetail(ScreenShotDto dto) {
		ScreenShotEntity entity =  screenShotRepository.getScreenShotInfo(dto.getScreenShotIdx());	
		
		ScreenShotDto result  = ScreenShotDto.builder()
				.screenShotIdx(entity.getScreen_shot_idx())
				.journeyStrtDtm(entity.getJourney_strt_dtm())
				.thumbnailPath(entity.getThumbnail_path())
				.userIdx(entity.getUser_idx())
				.position(entity.getPosition())
				.gameIdx(entity.getGame_idx())
				.title(entity.getTitle())
				.description(entity.getDescription())
				.tag(entity.getTag())
				.gameNm(entity.getGame_nm())
				.corp_nm(entity.getCorp_nm())
				.build();
		
		return result;
	}
	
	@Transactional
	public List<ScreenShotCommentDto> listShotCommentById(ScreenShotDto dto){
		List<ScreenShotCommentEntity> commentEntites = screenShotCommentRepository.listShotCommentById(dto.getScreenShotIdx());
		List<ScreenShotCommentDto> commentDtoList = new ArrayList<>();
		
		commentEntites.forEach(comment ->{
			ScreenShotCommentDto commentDto = ScreenShotCommentDto.builder()
					.screenShotCommentIdx(comment.getScreen_shot_comment_idx())
					.screenShotIdx(comment.getScreen_shot_idx())
					.userIdx(comment.getUser_idx())
					.commentContent(comment.getComment_content())
					.nickNm(comment.getNick_nm())
					.profileImgPath(comment.getProfile_img_path())
					.build();
			
			commentDtoList.add(commentDto);
			
		});
		
		return commentDtoList;
	}
	
	@Transactional
	public List<Map<String,Object>> listRecommendGame(String tags, Long idx){
		
		List<Map<String,Object>> list = new ArrayList<>();
		
		Set<String> set = new HashSet<>();
		
		set.addAll(Arrays.asList( tags.split(",")));
		
		Object[] result = screenShotRepository.listRecommendGame(set, idx );
		//SCREEN_SHOT_IDX  ,a.THUMBNAIL_PATH as Thumb_shot ,gi.GAME_NM ,gi.THUMBNAIL_PATH \r\n"

		
		for (int i = 0; i < result.length; i++) {
			Map<String,Object> map =new HashMap<>();
			
			Object[] a = (Object[]) result[i];
			map.put("screenShotIdx", a[0]);
			map.put("thumbnailScreenShot", a[1]);
			map.put("gameNm", a[2]);
			map.put("thumbnailGame", a[3]);
			
			list.add(map);
		}
		
		return list;
	}
	
	@Transactional
	public List<ScreenShotImgDto> listScreenShotForToons(ScreenShotDto dto){
		List<ScreenShotImgDto> returnList = new ArrayList<>();
		List<ScreenShotImgEntity> list = screenShotImgRepository.getScreenShotImgEntityByScreenShotIdx(dto.getScreenShotIdx());
		
		list.forEach(img ->{
			ScreenShotImgDto imgdto = ScreenShotImgDto.builder()
					.idx(img.getIdx())
					.screenShotIdx(img.getScreenShotIdx())
					.img_path(img.getImg_path())
					.smi(img.getSmi())
					.build();
			
			returnList.add(imgdto);
		});
		
		return returnList;
	}
}
