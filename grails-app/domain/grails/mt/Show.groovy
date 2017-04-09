package grails.mt

import grails.gorm.MultiTenant

class Show implements MultiTenant<Show> {

    String city
    Double price
    Date when

    static constraints = {
    }
}
