package com.ccfraser.muirwik.components.expansionpanel

import com.ccfraser.muirwik.components.createStyled
import csstype.ClassName
import react.ComponentType
import react.RBuilder
import styled.StyledHandler
import styled.StyledProps

@JsModule("@material-ui/core/ExpansionPanelDetails")
private external val expansionPanelDetailsModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val expansionPanelDetailsComponentType: ComponentType<StyledProps> = expansionPanelDetailsModule.default

@Deprecated("Getting removed in Material-UI 5", ReplaceWith("mAccordionDetails(className, handler)",
		"com.ccfraser.muirwik.components.accordion.mAccordionDetails"))
fun RBuilder.mExpansionPanelDetails(
	className: ClassName? = null,
	handler: StyledHandler<StyledProps>? = null
) {
	createStyled(expansionPanelDetailsComponentType, className, handler)
}
