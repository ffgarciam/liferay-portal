<#assign function = functionElement.attributeValue("function")>

<#if functionElement.getName() == "execute" && function?starts_with("Is")>
	return
</#if>

<#assign x = function?last_index_of("#")>

${seleniumBuilderFileUtil.getVariableName(function?substring(0, x))}Function.${function?substring(x + 1)}(

<#if functionElement.attributeValue("ignore-javascript-error")??>
	<#assign ignoreJavaScriptError = functionElement.attributeValue("ignore-javascript-error")>

	"${ignoreJavaScriptError}",
<#elseif functionName??>
	ignoreJavaScriptError,
<#else>
	null,
</#if>

<#assign functionLocatorCount = seleniumBuilderContext.getFunctionLocatorCount(seleniumBuilderFileUtil.getObjectName(function?substring(0, x)))>

<#list 1..functionLocatorCount as i>
	<#if functionElement.attributeValue("locator${i}")??>
		<#assign locator = functionElement.attributeValue("locator${i}")>

		"${locator}"
	<#elseif actionName?? || functionName??>
		locator${i}
	<#else>
		""
	</#if>

	,

	<#if functionElement.attributeValue("value${i}")??>
		<#assign functionValue = functionElement.attributeValue("value${i}")>

		"${functionValue}"
	<#elseif actionName?? || functionName??>
		value${i}
	<#else>
		""
	</#if>

	<#if i_has_next>
		,
	</#if>
</#list>

)

<#if functionElement.getName() == "execute">
	;
</#if>