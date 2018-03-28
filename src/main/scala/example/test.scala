package example

import com.amazonaws.services.lambda.runtime.Context
import com.lifeway.aws.lambda._
import io.circe.Decoder

case class InputType(data: String)

object InputType {
  implicit val decoder: Decoder[InputType] = Decoder.forProduct1("data")(InputType.apply)
}

class HandlerNoBody extends ProxyNoBodyTypedError[String] {
  override def handler(request: APIGatewayProxyRequestNoBody, c: Context): Proxy.Response[Errors, String] = {
    //TODO: your biz logic, response is Left / Right APIGatewayProxyResponse of either Errors type or String type.
    Right(APIGatewayProxyResponse(200, None, Some("My Successful String!")))
  }
}

class HandlerWithBody extends ProxyWithBodyTypedErrors[InputType, String] {
  override def handler(request: APIGatewayProxyRequest[InputType], c: Context): Proxy.Response[Errors, String] = {
    //TODO: your biz logic, response is Left / Right APIGatewayProxyResponse of either Errors type or String type.
    val input = request.body.data.reverse //my input type decoded!
    Right(APIGatewayProxyResponse(200, None, Some(input)))
  }
}