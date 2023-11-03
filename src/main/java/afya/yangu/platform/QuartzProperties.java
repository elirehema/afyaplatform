package afya.yangu.platform;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties("com.juliuskrah.quartz")
@Setter
@Getter
public class QuartzProperties {
	private Resource configLocation;
}
