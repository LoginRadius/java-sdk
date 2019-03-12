import com.loginradius.demo._
import org.scalatra._
import javax.servlet.ServletContext

import com.loginradius.sdk.util.LoginRadiusSDK
import com.loginradius.sdk.resource.LoginRadiusClient

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
  	var loginradius: LoginRadiusSDK.Initialize = new LoginRadiusSDK.Initialize()
  	var client: LoginRadiusClient = new LoginRadiusClient()

  	loginradius.setApiKey(credentials.apiKey)
  	loginradius.setApiSecret(credentials.apiSecret)

    context.mount(new Minimal(client), "/*")
    context.mount(new User(client), "/user")
  }
}
