package grails.mt

import org.grails.datastore.mapping.multitenancy.AllTenantsResolver
import org.grails.datastore.mapping.multitenancy.TenantResolver
import org.grails.datastore.mapping.multitenancy.exceptions.TenantNotFoundException
import org.hibernate.criterion.DetachedCriteria
import org.springframework.web.context.request.RequestAttributes
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletWebRequest

class MyTenantResolver implements TenantResolver, AllTenantsResolver {

    @Override
    Iterable<Serializable> resolveTenantIds() {
        new DetachedCriteria(Show).distinct('tenantId').list()
    }

    @Override
    Serializable resolveTenantIdentifier() throws TenantNotFoundException {

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes()
        if(requestAttributes instanceof ServletWebRequest) {

            String subdomain = ((ServletWebRequest) requestAttributes).getRequest().getRequestURL().toString()
            subdomain = subdomain.substring(subdomain.indexOf("/") + 2)
            subdomain = subdomain.substring(0, subdomain.indexOf("."))
            return subdomain

        } else {
            throw new TenantNotFoundException("Tenant could not be resolved outside a web request")
        }
    }
}