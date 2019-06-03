# Liferay-JSF-Mailer
-------------------

Liferay-JSF-Mailer is an example on how to send mail using a
Jave Server Faces Portlet with Liferay 7.1.3 GA4.  It uses Maven
to compile the war file.

Usage
-----

With maven, build with "clean verify install" goals, then deploy to Liferay.

Installation
------------

### Liferay Mail Configuration (Configuration is for a GMail account) adjust as required.

Go to Admin->Control Panel->Server Administration->Mail

Fill in the form as follows:
Incoming POP Server: pop.gmail.com

Incoming port: 995

Check "Use a secure network configuration"

Fill in your user name and password.

Outgoing SMTP Server: smtp.gmail.com

Outgoing port: 465

Check "Use a secure network configuration"

Again, fill in your user name and password.

Press "Save" button.

### Eclipse Configuration

Use "Add and Remove" to add to Liferay Server if running in Eclipse the 
Liferay-JSF-Mailer project.  Otherwise deploy as usual by making the 
war as explained above and copy to the deploy folder.

Meta
----

* Home: <https://github.com/jlmoya/Liferay-JSF-Mailer>
* Bugs: <https://github.com/jlmoya/Liferay-JSF-Mailer/issues>
* Authors: <https://github.com/jlmoya/Liferay-JSF-Mailer/contributors>
