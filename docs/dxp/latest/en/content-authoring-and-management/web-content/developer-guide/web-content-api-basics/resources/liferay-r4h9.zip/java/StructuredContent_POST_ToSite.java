import com.liferay.headless.delivery.client.dto.v1_0.ContentField;
import com.liferay.headless.delivery.client.dto.v1_0.ContentFieldValue;
import com.liferay.headless.delivery.client.dto.v1_0.StructuredContent;
import com.liferay.headless.delivery.client.resource.v1_0.StructuredContentResource;

public class StructuredContent_POST_ToSite {

	/**
	 * java -classpath .:* -DcontentStructureId=1234 -DsiteId=5678 StructuredContent_POST_ToSite
	 */
	public static void main(String[] args) throws Exception {
		StructuredContentResource.Builder builder =
			StructuredContentResource.builder();

		StructuredContentResource structuredContentResource =
			builder.authentication(
				"test@liferay.com", "test"
			).build();

		StructuredContent structuredContent =
			structuredContentResource.postSiteStructuredContent(
				Long.valueOf(System.getProperty("siteId")),
				new StructuredContent() {
					{
						contentFields = new ContentField[] {
							new ContentField() {
								{
									contentFieldValue =
										new ContentFieldValue() {
											{
												data = "<p>Foo</p>";
											}
										};
									name = "content";
								}
							}
						};
						contentStructureId = Long.valueOf(
							System.getProperty("contentStructureId"));
						title = "Charlie Article";
					}
				});

		System.out.println(structuredContent);
	}

}