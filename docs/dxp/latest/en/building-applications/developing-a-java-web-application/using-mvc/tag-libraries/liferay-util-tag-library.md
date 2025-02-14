# Liferay Util Tag Library

```{toctree}
:maxdepth: 3

liferay-util-tag-library/liferay-util-body-bottom.md
liferay-util-tag-library/liferay-util-body-top.md
liferay-util-tag-library/liferay-util-buffer.md
liferay-util-tag-library/liferay-util-dynamic-include.md
liferay-util-tag-library/liferay-util-get-url.md
liferay-util-tag-library/liferay-util-html-bottom.md
liferay-util-tag-library/liferay-util-html-top.md
liferay-util-tag-library/liferay-util-include.md
liferay-util-tag-library/liferay-util-param.md
liferay-util-tag-library/liferay-util-whitespace-remover.md
```

The Liferay Util taglib is used to pull other resources into a portlet or theme. You can use it to specify which resources to insert at the bottom or top of the page's HTML. 

To use the Liferay-Util taglib, add the following declaration to your JSP:

```jsp
<%@ taglib prefix="liferay-util" uri="http://liferay.com/tld/util" %>
```

The Liferay-Util taglib is also available via a macro for your FreeMarker theme templates and web content templates. Follow this syntax:

```
<@liferay_util["tag-name"] attribute="string value" attribute=10 />
```

This section covers the available Liferay Util tags you can use in your app to inject content into portlets and themes.