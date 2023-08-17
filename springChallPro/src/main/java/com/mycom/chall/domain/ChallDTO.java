package com.mycom.chall.domain;

import java.util.Date;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
/*lombok에서 사용가능한 @들
  @Data : @Setter,@Getter,@ToString,@EqualsAndHashCode
 @NoArgsConstructor
 @AllArgsConstructor  등*/
//member 테이블관련 data저장,제공 등의 기능을 제공 클래스
public class ChallDTO {

	private int chall_no;
	private int cate_no;
	private String chall_title;
	private int mem_no;
	private Date  chall_write_date;
	private String  chall_con;
	private String certifi_words;
	private String nickname;
	private String cate_name;
	
}
