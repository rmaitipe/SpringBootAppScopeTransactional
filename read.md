By default, Spring beans are singletons. 
The problem arises when we try to wire beans of different scopes. For example, a prototype bean into a singleton.
Individually when a prototype bean used, every time a new instance is expected and for singleton the same instance.
If you observe in this example no new instance of prototype bean is created. Every time the same instance which is created at the start-up is returned.

Solutions
Injecting ApplicationContext   Implement ApplicationContextAware or @Autowire annotation (Commented out)
Method Injection               Use @Lookup annotation (Easiest solution, Commented out)
javax.inject API
Scoped Proxy
ObjectFactory Interface (Used in the example here)
Create a Bean at Runtime Using java.util.Function

Part I & II looks at Prototype Bean Injection Problem
Part III Transactional - The 2nd update method has a npe and as a result commit transaction is rolled back.

https://stackoverflow.com/questions/59530693/does-it-make-sense-to-use-springs-transactional-annotation-in-a-method-which-d
https://stackoverflow.com/questions/812415/why-is-springs-applicationcontext-getbean-considered-bad
https://www.baeldung.com/spring-inject-prototype-bean-into-singleton
https://faun.pub/solution-for-scoped-bean-injection-problem-in-spring-91de3c9daa20


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