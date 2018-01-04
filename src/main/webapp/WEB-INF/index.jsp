
<%@page import="com.example.togglzexample.MyFeatures"%>
<%@page import="org.togglz.core.context.FeatureContext"%>
<html>
<body>

	<h1>Bhawani</h1>
  <p>
    Current user:
    <%=FeatureContext.getFeatureManager().getCurrentFeatureUser().getName()%>
  </p>

  <ul>
    <li><strong>ADMIN_FEATURE</strong>: <%=MyFeatures.FEATURE_ONE.isActive()%></li>
    <li><strong>TALKING_FEATURE</strong>: <%=MyFeatures.FEATURE_TWO.isActive()%></li>
  </ul>

  <p>
    <a href="<%=request.getContextPath()%>/togglz/">Admin Console</a>
  </p>

</body>
</html>
