Update the userName/password in applicationProperties
Part I & II looks at Prototype Bean Injection Problem
Part III Transactional - Left for phase 2 as MongoDB doesn't support transactions out of Box- And since transactional only applies to DB operation - the messages will be same now

https://stackoverflow.com/questions/59530693/does-it-make-sense-to-use-springs-transactional-annotation-in-a-method-which-d
https://stackoverflow.com/questions/812415/why-is-springs-applicationcontext-getbean-considered-bad
https://www.baeldung.com/spring-inject-prototype-bean-into-singleton

In Part I
SpringSingletonBean Bean created
SpringPrototypeBean created
11:06:57.894
// should create another prototype bean instance here
11:06:58.895
Both beans were initialized only once, at the startup of the application context.

In Part II ObjectFactory Interface Solution
12:22:26.679
SpringPrototypeForLookUpBean instance created
12:22:26.679
SpringPrototypeForLookUpBean instance created

In Part III
@Transactional ==  @Transactional(rollbackFor = { RuntimeException.class, Error.class })
The rollbackFor attribute indicates Spring to rollback the transaction for the given exception

UserTransaction utx = entityManager.getTransaction(); 
try { 
    utx.begin(); 
    businessLogic();
    utx.commit(); 
} catch(Exception ex) { 
    utx.rollback(); 
    throw ex; 
} 
The above progammatic code is same as
@Transactional
public void businessLogic() {
... use entity manager inside a transaction ...
}