package com.ccfraser.muirwik.components.accordion

import com.ccfraser.muirwik.components.createStyled
import csstype.ClassName
import react.ComponentType
import react.RBuilder
import styled.StyledHandler
import styled.StyledProps

@JsModule("@material-ui/core/AccordionDetails")
private external val accordionDetailsModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val accordionComponentType: ComponentType<StyledProps> = accordionDetailsModule.default

fun RBuilder.mAccordionDetails(
	className: ClassName? = null,
	handler: StyledHandler<StyledProps>? = null
) {
	createStyled(accordionComponentType, className, handler)
}
