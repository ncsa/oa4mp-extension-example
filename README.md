## OA4MP extension example

An example for how to extend OA4MP using Java. This has the barebone files thare needed 
to write your own user-aware extension to OA4MP in Java. The use case is that you 
have an existing usermanagement system (possibly in Java) that you want to use for
authentication. All of the configuration for this is in place in OA4MP right out of the box, 
except that there are no configured 
users, hence attempting to run OA4MP will always result in a user login error.

# To start

Download this project from GitHub or a specific release. All OA4MP dependencies are included
and it should just work.

# Basic steps

1. Override AuthenticationUtil's checkUser method. This is called for you during log in
2. To support the Authorization code flow: Override OA2AuthenticationServer's init method, setting your authetication utility
3. To support the Device code flow: Override RFC8628AuthenticationServer's init method
4. Update the web.xml file to point to these
5. (Optional) update the authorize-init.jsp and possibly device-init.jsp files for any customizations you want.

# The example at hand
The example files are

1. ExAuthenticationUtil
2. ExAuthenticationServer
3. ExRFC8628AuthenticationServer
4. web.xml

All of these are extremely minimalist (aka an application of *Kanso*) so that the actual structure of what needs done 
is shown. In practice, the AuthenticationUtil extension you write may end up being
an imposing database application that links users and various logins. However, any sufficiently
complex example would hide the essential simplicity. For instance, we *could* have had some
much more complex injection framwork do the bootstrapping work, but opted here for 
overriding the two servlet classes, since ultimately, that is what would be done. 

**Nota Bene:** The example (and it is an example) supports precisely one user named `me`
with the ever so popular password `1234567890`. This is, of course, to illustrate how it 
works, naught else.  

## Deployment

Simply run 

`mvn clean install`

from the main directory. The result will be `target\oauth2.war` which is the deployable
OA4MP webapp. Be sure you have OA4MP configured (so a functional server configuration and
such) and deploy it by copying it to the `$CATALINA_HOME\webapps` directory, where it
should simply deploy on its own. You will need a client (the OA4MP CLC or command line client
is a dandy choice) that is registered then simply start your preferred flow and log in. 


