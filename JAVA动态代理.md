# JavaCodeDemo

转自https://www.jianshu.com/p/95970b089360

之前讲了《零基础带你看Spring源码——IOC控制反转》，本来打算下一篇讲讲Srping的AOP的，但是其中会涉及到Java的动态代理，所以先单独一篇来了解下Java的动态代理到底是什么，Java是怎么实现它的。

动态代理看起来好像是个什么高大上的名词，但其实并没有那么复杂，直接从字面就很容易理解。动态地代理，可以猜测一下它的含义，在运行时动态地对某些东西代理，代理它做了其他事情。先不去搞清楚这个动态代理真正的含义，我们来举个生动的例子来理解下它到底做了什么。

一个例子
一个程序员Developer，他会开发code，他调试debug。

程序员有很多分类，其中有Java程序员JavaDeveloper，他会开发Java代码，会调试Java代码。

但是呢，有个叫Zack的程序员它在开发之前，会祈祷一下，这样他开发的代码就不会有bug。
Zack的这种“特异功能”是后天练出来的，并没有哪种程序员有这种特性。虽然我们也可以定义一个拥有这样特性的程序员，但是拥有各种乱七八糟特性的程序千千万。我们什么时候才能定义完，而能保证不漏呢？

其实我们没有必要去定义他，因为他是后天养成的，我们应该在这个程序员的成长期去实现这个特性，而不是在他出生之前定义。

我们来看下代码是怎么实现的



如果Zack只是一个普通的Java程序员，那么他的开发结果是
Zack is coding java
Zack is debugging java

但是真正的Zack（代理后）
Zack is praying for the code!
Zack is coding java
Zack's have no bug！No need to debug!

Proxy.newProxyInstance()
回看下上面是如何使用动态代理的使用。生成一个实例对象，然后用Proxy的newInstance方法对这个实例对象代理生成一个代理对象。



这里有一个非常关键的人，也是比较少人去理解它的。为什么要传zack的类加载和zack的接口呢？
有没有留意到zackProxy的类型是Developer接口，而不是一个实现类。因为zack在被代理后生成的对象，并不属于Developer接口的任何一个实现类。但是它是基于Developer接口和zack的类加载代理出来的。

看下newProxyInstance()的接口定义



这三个参数具体的含义来看看注解是怎么描述的



loder，选用的类加载器。因为代理的是zack，所以一般都会用加载zack的类加载器。
interfaces，被代理的类所实现的接口，这个接口可以是多个。
h，绑定代理类的一个方法。
loder和interfaces基本就是决定了这个类到底是个怎么样的类。而h是InvocationHandler，决定了这个代理类到底是多了什么功能。所以动态代理的内容重点就是这个InvocationHandler。

InvocationHandler

根据注解描述可知，InvocationHandler作用就是，当代理对象的原本方法被调用的时候，会绑定执行一个方法，这个方法就是InvocationHandler里面定义的内容，同时会替代原本方法的结果返回。

InvocationHandler接收三个参数

proxy，代理后的实例对象。
method，对象被调用方法。
args，调用时的参数。
在上面的例子里，



如果最后的return语句改成

return method.invoke(proxy, agrs);
invoke的对象不是zack，而是proxy，根据上面的说明猜猜会发生什么？
是的，会不停地循环调用。因为proxy是代理类的对象，当该对象方法被调用的时候，会触发InvocationHandler，而InvocationHandler里面又调用一次proxy里面的对象，所以会不停地循环调用。并且，proxy对应的方法是没有实现的。所以是会循环的不停报错

动态代理的原理
通过上面的讲解，相信大家对动态代理的使用理解得比较深刻了。那动态代理到底是怎么实现的呢，我们来看看源码其中关键的地方。
在newProxyInstance()发放中有这样几段。



其实大概就是把接口复制出来，通过这些接口和类加载器，拿到这个代理类cl。然后通过反射的技术复制拿到代理类的构造函数（这部分代码在Class类中的getConstructor0方法），最后通过这个构造函数new个一对象出来，同时用InvocationHandler绑定这个对象。

动态代理的使用场景
动态代理的好处我们从例子就能看出来，它比较灵活，可以在运行的时候才切入改变类的方法，而不需要预先定义它。

动态代理一般我们比较少去手写，但我们用得其实非常多。在Spring项目中用的注解，例如依赖注入的@Bean、@Autowired，事务注解@Transactional等都有用到，换言之就是Srping的AOP（切面编程）。

这种场景的使用是动态代理最佳的落地点，可以非常灵活地在某个类，某个方法，某个代码点上切入我们想要的内容，就是动态代理其中的内容。所以下一篇我们来细致了解下Spring的AOP到底是怎么使用动态代理的。

如果觉得还不错，请关注微信公众号：Zack说码
