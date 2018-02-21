import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TravelAssistApplication.class)
@TestExecutionListeners({ JMockitTestExecutionListener.class })
@ActiveProfiles("test")
public class SomeServiceMockitTest {

	private SomeService SomeService = new SomeService();

	@Mocked
	private  anyMapper anyMapper;

	@Before
	public void setUp() {
		// 初期化
	}

	/**
	 * ■対象メソッド：getSpeed<br>
	 * ・正常系
	 * 移動手段 WALK
	 * @throws Exception
	 */
	@Test
	public void testPrivateMethod01() throws Exception {

		// =========================================================================
		// 事前準備
		// =========================================================================
		// 対象メソッドがprivate
		Method method = SomeService.class.getDeclaredMethod("getSpeed", String.class, TransportationEnum.class);
		method.setAccessible(true);

		Field field = SomeService.class.getDeclaredField("anyMapper");
		field.setAccessible(true);
		field.set(SomeService, anyMapper);

		// =========================================================================
		// モック定義
		// =========================================================================
		new Expectations() {
			{
				// anyMapper
				anyMapper.selectRegionParam(anyString, anyString, anyString);
				result = "002";
				minTimes = 0;
			}
		};

		// =========================================================================
		// テスト実行
		// =========================================================================
		String StringParm1 = "001";
		String StringParm2 = "002";
		Float result = (Float)method.invoke(SomeService, StringParm1, StringParm2);

		assertNotNull(result);
	}
}
