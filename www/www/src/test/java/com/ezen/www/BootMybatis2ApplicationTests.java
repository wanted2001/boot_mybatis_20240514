package com.ezen.www;

import com.ezen.www.domain.BoardVO;
import com.ezen.www.repository.BoardMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootMybatis2Application.class)
class BootMybatis2ApplicationTests {

	@Autowired
	private BoardMapper mapper;

	@Test
	void contextLoads() {
		for(int i=0; i<=300; i++){
			BoardVO bvo = BoardVO
					.builder()
					.title("Title"+i)
					.writer("tester@test.com"+i)
					.content("Test Content"+i)
					.build();
			mapper.insert(bvo);
		}
	}


}
