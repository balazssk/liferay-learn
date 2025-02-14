import com.liferay.headless.delivery.client.dto.v1_0.WikiNode;
import com.liferay.headless.delivery.client.pagination.Page;
import com.liferay.headless.delivery.client.pagination.Pagination;
import com.liferay.headless.delivery.client.resource.v1_0.WikiNodeResource;

public class WikiNodes_GET_FromSite {

	/**
	 * java -classpath .:* -DsiteId=1234 WikiNodes_GET_FromSite
	 */
	public static void main(String[] args) throws Exception {
		WikiNodeResource.Builder builder = WikiNodeResource.builder();

		WikiNodeResource wikiNodeResource = builder.authentication(
			"test@liferay.com", "test"
		).build();

		Page<WikiNode> page = wikiNodeResource.getSiteWikiNodesPage(
			Long.valueOf(System.getProperty("siteId")), null, null, null,
			Pagination.of(1, 2), null);

		System.out.println(page);
	}

}