package com.ccfraser.muirwik.components.expansionpanel

import com.ccfraser.muirwik.components.StyledPropsWithCommonAttributes
import com.ccfraser.muirwik.components.createStyled
import csstype.ClassName
import org.w3c.dom.events.Event
import react.ComponentType
import react.RBuilder
import styled.StyledHandler

@JsModule("@material-ui/core/ExpansionPanel")
private external val expansionPanelModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val expansionPanelComponentType: ComponentType<MExpansionPanelProps> = expansionPanelModule.default

external interface MExpansionPanelProps : StyledPropsWithCommonAttributes {
	var defaultExpanded: Boolean
	var disabled: Boolean
	var expanded: Boolean
	var onChange: (Event, Boolean) -> Unit
}

@Deprecated("Getting removed in Material-UI 5", ReplaceWith("mAccordion(expanded, defaultExpanded, disabled, square, " +
		"onChange, className, handler)", "com.ccfraser.muirwik.components.accordion.mAccordion"))
fun RBuilder.mExpansionPanel(
	expanded: Boolean? = null,
	defaultExpanded: Boolean = false,
	disabled: Boolean = false,
	onChange: ((Event, Boolean) -> Unit)? = null,
	className: ClassName? = null,
	handler: StyledHandler<MExpansionPanelProps>? = null
) {
	createStyled(expansionPanelComponentType, className, handler) {
		attrs.defaultExpanded = defaultExpanded
		attrs.disabled = disabled
		expanded?.let { attrs.expanded = it }
		onChange?.let { attrs.onChange = it }
	}
}
