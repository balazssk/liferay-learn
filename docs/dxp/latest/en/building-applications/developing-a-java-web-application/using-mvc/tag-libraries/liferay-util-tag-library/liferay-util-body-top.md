# Using Liferay Util Body Top

The body top tag is not a self-closing tag. The content placed between the opening and closing of this tag is moved to the top of the `body` tag. When something is passed using this taglib, the  [body_top.jsp](https://github.com/liferay/liferay-portal/blob/7.2.x/portal-web/docroot/html/common/themes/body_top.jsp#L25-L31) is passed markup and outputs in this JSP.

This tag also has an optional `outputKey` attribute. If several portlets on the page include the same resource with this tag, you can specify the same `outputKey` value for each tag so the resource is only loaded once. 

The example configuration below uses the `<liferay-util:body-top>` tag to include JavaScript provided by the portlet's bundle:

```jsp
<liferay-util:body-top outputKey="bodytop" >
	<script 
  src="/o/my-liferay-util-portlet/js/my_custom_javascript_body_top.js" 
  type="text/javascript"></script>
</liferay-util:body-top>
```

Now you know how to use the `<liferay-util:body-top>` tag to include additional resources in the top of the page's body.

## Related Topics

* [Using the Liferay Util HTML Body Bottom Tag](./liferay-util-body-bottom.md)
* [Using the Liferay Util HTML Bottom Tag](./liferay-util-html-bottom.md)
* [Using the Clay Taglib](../clay-tag-library.md)