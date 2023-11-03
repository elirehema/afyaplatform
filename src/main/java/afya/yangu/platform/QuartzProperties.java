package afya.yangu.platform;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties("afya.yangu.platform")
@Setter
@Getter
public class QuartzProperties {
	private Resource configLocation;
}
