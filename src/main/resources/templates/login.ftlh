<#import "parts/common.ftlh" as c>
<#import "parts/logreg.ftlh" as l>

<@c.page>
    <div class="mb-3">
        Страница входа
    </div>
    <#if Session?? && Session.SPRING_SECURITY_LAST_EXCEPTION??>
        <div class="alert alert-danger" role="alert">
            ${Session.SPRING_SECURITY_LAST_EXCEPTION.message}
        </div>
    </#if>
    <#if message??>
        <div class="alert alert-${messageType}" role="alert">
            ${message}
        </div>
    </#if>

    <@l.login "/login" false/>
</@c.page>
