package com.ccfraser.muirwik.components.button

import com.ccfraser.muirwik.components.*
import org.w3c.dom.events.Event
import react.ComponentType
import react.RBuilder
import react.ReactElement
import react.ReactNode
import styled.StyledHandler


@JsModule("@material-ui/core/Button")
private external val buttonModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val buttonComponentType: ComponentType<MButtonProps> = buttonModule.default


external interface MButtonProps : MButtonBaseProps {
    var disableFocusRipple: Boolean
    var disableElevation: Boolean
    var endIcon: ReactElement
    var fullWidth: Boolean
    var href: String
    var startIcon: ReactElement
}
//var MButtonProps.color by EnumPropToStringNullable(MColor.values())
var MButtonProps.color by EnumPropToString(MColor.values())
var MButtonProps.size by EnumPropToString(MButtonSize.values())
var MButtonProps.variant by EnumPropToStringNullable(MButtonVariant.values())


//Setting the color and variant to the default values seems to upset button groups... the buttons don't inherit the
//groups color or variant, even if color is default... so allowing color and variant to default to null which seems
//to fix the issue and does not cause any issues
fun RBuilder.mButton(
    caption: String,
    color: MColor = MColor.default,
    variant: MButtonVariant? = null,
    disabled: Boolean = false,
    onClick: ((Event) -> Unit)? = null,
    size: MButtonSize = MButtonSize.medium,
    hRefOptions: HRefOptions? = null,
    className: String? = null,
    handler: StyledHandler<MButtonProps>? = null
) {
    createStyled(buttonComponentType, className, handler) {
        attrs.color = color
        attrs.disabled = disabled
        hRefOptions?.let { setHRefTargetNoOpener(attrs, it) }
        onClick?.let { attrs.onClick = onClick }
        attrs.size = size
        attrs.variant = variant

        childList.add(ReactNode(caption))
    }
}

