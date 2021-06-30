/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author dell
 */
public class ServiceLocator {

    private static Cache cache;

    static {
        cache = new Cache();
    }

    public static BusinessService getService(String serviceName) {

        BusinessService service = cache.getService(serviceName);

        if (service != null) {
            return service;
        } else {
            InitialContext context = new InitialContext();
            service = (BusinessService) context.lookup(serviceName);
            cache.addService(service);
        }

        return service;
    }
}
