<!DOCTYPE html>
<%@page import="com.loginradius.sdk.resource.Sott"%>
<%@page import="com.loginradius.sdk.util.LoginRadiusSDK"%>
<html>
    <head>
        <title>LoginRadius | Customer Registration Java Demo</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"> -->
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
         <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
         <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/jquery-ui.min.js"></script>
         <script src="https://auth.lrcontent.com/v2/js/LoginRadiusV2.js"></script>
        <script src = "assets/js/option.js"></script>
        <script src="assets/js/LoginRadiusLoginScreen.1.0.0.js"></script>
        
    <link rel="stylesheet" type="text/css" href="assets/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="assets/css/customize.css"/>
   


        <!-- Production -->
       
</head>
<body>
    <!-- Start Things -->
    <div class="main">
        <nav class="main-nav sticky-nav">
            <div class="container cf">
                <div class="logo no-text">
                    <div class="logo-box">
                        <h1 class="logo">
                            <a href="/">LoginRadius</a>
                        </h1>
                        <div class="site-description">Java Demo</div>
                    </div>
                </div>

                <!-- Fragment Caching -->
                <div class="secondary-menu">
                    <ul id="menu-top-menu" class="menu">
                        <li id="loginaction"><a class="lr-raas-button lr-raas-theme-login trigger_popup">Click to Login</a>
                           
                    </ul>
                </div>
            </div>
        </nav>
        <div id="homeinformation" class="lr-frame lr-input-style">
            <h2>A Complete User Authentication Solution </h2>

            <div style="  text-align: left;margin-top:20px;">
                Want to offer your users a choice between Social Login and Traditional Registration?
                We offer both, so you can manage all of your authentication systems in one place. LoginRadius Customer Registration
                and Social Login solutions work seamlessly together for a simplified registration system.
            </div>
            <div style="  text-align: left;margin-top:20px;">
                <h3>1. Managed Registration Service</h3>
                Our Managed Registration Service is a full user authentication solution for your web and mobile applications.
                The managed solution eliminates all the associated hassles with maintaining registration forms, and saves your
                engineering team significant time and resources.

                <h3>2. Fully Customizable</h3>
                LoginRadius Registration Service allows you to fully customize the registration form and login screen to match
                the look and feel of your website.

                <h3>3. Email Verification & Forgotten Service</h3>
                Email Verification of new sign-ups and forgotten username/password retrieval are simple fixes with LoginRadius
                Managed Registration.

                <h3>4. Custom Emails</h3>
                You can easily set custom email templates and content for email verification and forgotten usernames and
                password service. LoginRadius system also has the capability to connect to your existing email service
                provider.

                <h3>5. User Data Management</h3>
                Data storage is provided to help you manage your users and their data. You keep full ownership of the data and
                have full access at all times. LoginRadius also delivers a copy of the data to your local database.

                <h3>6. Works with Social Login</h3>
                Our Registration Service comes with Social Login and Social Account Linking. Your existing users can choose to
                migrate to Social Login if they would prefer, or log-in through Traditional Registration. Both systems work
                together seamlessly.

                <h3>7. Works with all Major Technologies</h3>
                The LoginRadius Platform works with all popular web technologies; WordPress, Drupal, Joomla, PHP, .NET,
                Javascript, Android, iOS and many more. You can see the complete list here.
            </div>

        </div>
        
        <div id="profileinformation" class="lr-frame lr-input-style" style="display: none;">
            <h2>My Profile</h2>
            <div style="text-align: left;margin-top:20px;">
                <div id="profiledata"></div>
            </div>
        </div>
    </div>
    <!---//End-wrap---->
    <footer>
        <div class="overlay" id="fade" style="display: none;">
            <div class="circle">
                <div id="imganimation">
                    <img src="//cdn.loginradius.com/demo/common/loading_spinner.gif" alt="LoginRadius Processing"
                         style="margin-top: -66px;margin-left: -73px;width: 338px;height: 338px;">
                </div>
            </div>
        </div>
        <div class="clear"></div>
        <div class="copy-right">
            <p>Customer Registration Demo by <a href="https://www.LoginRadius.com/" target="_blank">LoginRadius</a></p>
        </div>
    </footer>
    
    <div class="pop_up" style="display: none;">
         <span class="helper"></span>
        <div>
            <div class="pop_header">
               
                    <div class="popup_close_button">
                        <img src="assets/images/cross-icon.svg" width="20px" />
                    </div>
                
            </div>
            <div class="pop_body">
                <div id="distinct-container"></div>
                <br>
            </div>
        </div>
    </div>
</body>

 <%
String apikey=application.getInitParameter("LoginRadiusApiKey");
String apisecret=application.getInitParameter("LoginRadiusSecret");

LoginRadiusSDK.Initialize init = new LoginRadiusSDK.Initialize();
init.setApiKey(apikey);
init.setApiSecret(apisecret);
//init.setRequestSigning(true);

Sott getsott =new Sott();
String sott =getsott.main(apisecret,apikey,null);
if(apikey.isEmpty()){%>
<script> alert("please configure your api key and secret in web.xml");</script>
<% } %>

    <script type="text/javascript">
    $( document ).ready(function() {
        $(".trigger_popup").click(function(){
           $('.pop_up').show();
           $('body').addClass("fixed");
        });
        $('.popup_close_button').click(function(){
            $('.pop_up').hide();
            $('body').removeClass("fixed");
        });
    });
    var commonOptions = {};
    commonOptions.apiKey = "<%=application.getInitParameter("LoginRadiusApiKey")%>";
    commonOptions.appName = "<%=application.getInitParameter("LoginRadiusSiteName")%>";
    commonOptions.hashTemplate= true;
    commonOptions.sott = "<%= sott %>";
    commonOptions.formValidationMessage=true;
    var path = window.location.href;
    commonOptions.verificationUrl = path;
    commonOptions.resetPasswordUrl = path;
    var LRObject= new LoginRadiusV2(commonOptions);

    commonOptions.v2RecaptchaSiteKey = '<your google ReCaptcha Key>';
    //To use Google ReCaptcha V2 set the following:
    commonOptions.v2Recaptcha = false;
    //If you would like to set Google Invisible ReCaptcha:
    commonOptions.invisibleRecaptcha = false;
    
    
    var options = {
            //language: "French",
            singlepagestyle: false,
            redirecturl: {
                afterlogin: "Profile.jsp",
                afterreset: "http://localhost:8888/loginscreen-version2.html",
            },
            socialsquarestyle: false,
            
            logo: {
              url: "https://docs.loginradius.com/theme/apidocs//support-assets/images/logo.svg",
              color: "#F8F8F8"
            },
            body: {
              backgroundColor: "#ffffff",
              textColor: "#",
              fontFamily: "Open Sans"
            },
            content: {
              tabLabels: ["Log in", "Sign Up", "Forgot Password"],
              forgotPWgreet: "Check your email",
              socialandloginDivider: "Or you can log in with email",
              socialblockLabel: "Log in with",
              signupandForgotPwrequest: "Please go to your email address and click the link",
              emailVerifiedMessage: "You have signed up successfully."
            },            
            input:{
              background: "#F5F5F5;"
            },
            submitButton: {
              color: "#2299DD"
            },
            pagesshown: ["login","signup", "forgotpassword"]
        };
    var cb= function(response,Event){
    
      console.log(response);
      console.log(Event);
    }
    var french = {
      "labels": { "emailid":  "Adresse e-mail",   "password":  "Mot de passe",  "confirmpassword": "Confirmez le mot de passe",  "stayLogin": "Souviens-toi de moi",  "lastname": "nom de famille", "prefix":"Préfixe", "suffix": "suffixe", "gender": "le genre", "birthdate": "Date de naissance", "state": "Etat", "phoneid": "ID de téléphone", "nickname": "surnom", "MiddleName": "Deuxième nom", "thumbnailimageurl": "URL de l'image miniature", "imageurl": "URL de l'image", "hometown": "Ville natale", "industry": "Industrie", "about": "Sur", "timezone": "Fuseau horaire", "mainAddress": "Adresse principale", "localCity": "Ville locale", "localCountry": "Pays local", "profileCountry": "Ville du profil", "relationshipStatus": "Statut de la relation", "religion":"Religion", "political": "Politique", "firstname": "Prénom", "username": "Nom d'utilisateur", "country": "Pays", "city": "Ville", "company": "Compagnie"},
      "placeholders": { "emailid":  "Entrez votre e-mail id",   "password":  "Entrez votre mot de passe", "confirmpassword": "Entrez à nouveau votre mot de passe"},
      "validationMessages": [
      {   "rule":  "required",   "message":  "Le champ %s est requis."  },
      {   "rule":  "valid_email",   "message":  "Le champ %s doit contenir une adresse e-mail valide."  },
      {   "rule":  "min_length",   "message":  "Le champ %s doit comporter au moins 6 caractères."  },
      {   "rule":  "matches",   "message":  "%s ne correspond pas"  }
      ],
      "errorMessages": [
      {   "code": 966,   "message":  "Nom d'utilisateur Mot de passe sont erron s",   "description":  "Nom d'utilisateur Mot de passe sont erron s, veuillez entrer la bonne combinaison de nom d'utilisateur Mot de passe"  },
      {   "code": 967,   "message":  "Id d'e-mail n'est pas format  valide",   "description":  "Id d'e-mail n'est pas format  valide"  },
      {   "code": 901,   "message":  "La cl  de l'API n'est pas valide",   "description":  "La cl  API LoginRadius fournis est non valide ou n'est pas autoris e, veuillez utiliser une cl  d'API LoginRadius valide ou v rifiez la cl  d'API pour votre compte LoginRadius."  },
      {   "code": 938,   "message":  "L'utilisateur n'existe pas",   "description":  "Le compte de l'utilisateur n'existe pas. Veuillez utiliser un utilisateur valide ou créer l'utilisateur avant de traiter cette demande."  },
      {   "code": 966,   "message":  "ID utilisateur et / ou mot de passe invalide",   "description":  "Veuillez utiliser une combinaison d'ID utilisateur et de mot de passe valide."  },
      {   "code": 967,   "message":  "L'email n'est pas verifié",   "description":  "Cet e-mail n'a pas encore été vérifié, veuillez cliquer sur le lien dans votre e-mail pour confirmer votre adresse e-mail."  },
      {   "code": 974,   "message": "Le lien de vérification par courriel a déjà été utilisé", "description": "Chaque lien ne peut être utilisé qu'une seule fois, vous pouvez vous connecter maintenant si vous avez déjà vérifié l'e-mail, OU utilisez l'option «Mot de passe oublié»." }
      ],
      "buttonsName":{
      "login": "connexion",
      "registration":"d'enregistrement",
      "forgotPassword": "envoyer",
      "resetPassword": "réinitialiser"
      },
      lscontent: {
        forgotPWgreet: "Vérifiez votre email",
        socialandloginDivider: "Ou",
        tabLabels: ["S'identifier", "S'inscrire", "Mot de passe oublié?"],
        socialblockLabel: "Connectez avec",
        resetpage: "réinitialiser le mot de passe",
        signupandForgotPwrequest: "S'il vous plaît aller à votre adresse e-mail et cliquez sur le lien",
        emailVerifiedMessage: "Enregistrement réussi"
      }
    }

    var spanish = {
      "labels": { "emailid":  "Dirección de correo electrónico",   "password":  "Contraseña",  "confirmpassword": "Confirmar contraseña",  "stayLogin": "Recuérdame",  "lastname": "Apellido", "prefix":"Prefijo", "suffix": "Sufijo", "gender": "género", "birthdate": "Fecha de nacimiento", "state": "Estado", "phoneid": "ID de teléfono", "nickname": "Apodo", "MiddleName": "Segundo nombre", "thumbnailimageurl": "URL de la imagen en miniatura", "imageurl": "URL de la imagen", "hometown": "Ciudad natal", "industry": "Industria", "about": "Acerca", "timezone": "Zona horaria", "mainAddress": "Dirección principal", "localCity": "Ciudad local", "localCountry": "País local", "profileCountry": "Perfil del país", "relationshipStatus": "Estado civil", "religion":"Religión", "political": "Político", "firstname": "Nombre de pila", "username": "Nombre de usuario", "country": "País", "city": "Ciudad", "company": "Empresa"},
      "placeholders": { "emailid":  "Ingrese su dirección de correo electrónico",   "password":  "Ingresa tu contraseña", "confirmpassword": "reingresa tu contraseña"},
      "validationMessages": [
      {   "rule":  "required",   "message":  "El campo %s es requerido."  },
      {   "rule":  "valid_email",   "message":  "El campo %s debe contener un correo electrónico válido."  },
      {   "rule":  "min_length",   "message":  "El campo %s debe tener al menos 6 caracteres de longitud."  },
      {   "rule":  "matches",   "message":  "%s no coincide"  }
      ],
      "errorMessages": [
      {   "code": 966,   "message":  "Usuario o contraseña incorrectos",   "description":  "Usuario o contraseña incorrectos, por favor ingrese la combinación correcta de nombre de usuario Contraseña"  },
      {   "code": 967,   "message":  "La identificación del correo electrónico no es un formato válido",   "description":  "La identificación del correo electrónico no es un formato válido"  },
      {   "code": 901,   "message":  "La clave de la API no es válida",   "description":  "La clave de la API de LoginRadius suministrada no es válida o no está permitida, utilice una clave API de LoginRadius válida o verifique la clave API para su cuenta de LoginRadius."  },
      {   "code": 938,   "message":  "el usuario no existe",   "description":  "La cuenta del usuario no existe, utilice un usuario válido o cree el usuario antes de procesar esta solicitud."  },
      {   "code": 966,   "message":  "ID de usuario y / o contraseña inválidos",   "description":  "Utilice una combinación válida de ID de usuario y contraseña."  },
      {   "code": 967,   "message":  "La contraseña actual no es válida",   "description":  "Su contraseña actual no es válida, por favor use la contraseña correcta."  },
      {   "code": 970,     "message": "Correo no identificado", "description": "Este correo electrónico aún no ha sido verificado, por favor haga clic en el enlace en su correo electrónico para confirmar su dirección de correo electrónico." },
      {   "code": 974,   "message": "El enlace de verificación de correo electrónico ya se ha utilizado", "description": "Cada enlace solo se puede usar una vez, puede iniciar sesión ahora si ya ha verificado el correo electrónico, O use la opción 'Olvidó su contraseña'." }
      ],
      "buttonsName":{
      "login": "conexión",
      "registration":"Regístrate",
      "forgotPassword": "Enviar",
      "resetPassword": "Reiniciar"
      },
      lscontent: {
        forgotPWgreet: "Consultar su correo electrónico",
        socialandloginDivider: "O",
        tabLabels: ["conexión", "Regístrate", "¿Se te olvidó tu contraseña?"],
        socialblockLabel: "Inicia con",
        resetpage: "restablecer la contraseña",
        signupandForgotPwrequest: "Por favor, vaya a su dirección de correo electrónico y haga clic en el enlace",
        emailVerifiedMessage: "Registro exitoso"
      }
    }

    var simplifiedchinese = {
      "labels": { "emailid":  "邮箱账号",   "password":  "密码",  "confirmpassword": "确认密码",  "stayLogin": "记住我",  "lastname": "姓", "prefix":"前缀", "suffix": "后缀", "gender": "性别", "birthdate": "出生日期", "state": "省份", "phoneid": "电话号码", "nickname": "昵称", "MiddleName": "中间名", "thumbnailimageurl": "图片网址", "imageurl": "图片网址", "hometown": "家乡", "industry": "行业", "about": "自我简介", "timezone": "所处时区", "mainAddress": "主要住址", "localCity": "现处城市", "localCountry": "现处国家", "profileCountry": "档案国家", "relationshipStatus": "婚姻状况", "religion":"信仰", "political": "政治倾向", "firstname": "名", "username": "用户名", "country": "国家", "city": "城市", "company": "公司"},
      "placeholders": { "emailid":  "邮箱地址",   "password":  "密码", "confirmpassword": "确认密码"},
      "validationMessages": [
      {   "rule":  "required",   "message":  "您需要输入%s。"  },
      {   "rule":  "valid_email",   "message":  " %s必须包含有效的电子邮件地址。"  },
      {   "rule":  "min_length  ",   "message":  "%s必须包含至少6位數。"  },
      {   "rule":  "matches",   "message":  "%s不符合"  }
      ],
      "errorMessages": [
      {   "code": 966,   "message":  "您输入的用户名或密码不正确",   "description":  "您输入的用户名或密码不正确，请输入正确的用户名密码组合"  },
      {   "code": 967,   "message":  "您输入的电子邮箱不是正确的格式",   "description":  "您输入的电子邮箱不是正确的格式"  },
      {   "code": 901,   "message":  "您输入的API密码不正确",   "description":  "你提供LoginRadius 的API密码不正确或者已经失效，请使用有效的API密码或者登陆您的LoginRadius账户验证您的API密码。"  },
      {   "code": 938,   "message":  "用户不存在",   "description":  "您输入的用户不存在，请使用一个有效的用户或者重新创建一个用户。"  },
      {   "code": 966,   "message":  "无效的用户名id和密码",   "description":  "请使用一个有效的用户名和密码。"  },
      {   "code": 967,   "message":  "您输入的密码错误",   "description":  "您输入的密码错误，请重试。"  },
      {   "code": 970,   "message":  "您尚未验证邮箱",   "description":  "您尚未验证邮箱，请通过您邮件的链接验证邮箱"  },
      {   "code": 974,   "message": "邮箱验证链接已经被使用", "description": "每个链接只能被使用一次，如果您已经成功验证邮箱，您可以直接登录，或者您可以用‘忘记密码’选项来重置密码。" }
      ],
      "buttonsName":{
      "login": "登陆",
      "registration":"注册",
      "forgotPassword": "发送",
      "resetPassword": "重置"
      },
      lscontent: {
        forgotPWgreet: "请登陆您的邮箱验证",
        socialandloginDivider: "或者您可以使用",
        tabLabels: ["登陆", "注册", "忘记密码？"],
        socialblockLabel: "使用",
        resetpage: "重置密码",
        signupandForgotPwrequest: "请登录邮箱验证",
        emailVerifiedMessage: "成功注册"
      }
    }

    var traditionalchinese = {
      "labels": { "emailid": "郵箱賬號", "password": "密碼", "confirmpassword": "確認密碼", "stayLogin": "記住我", "lastname": "姓", " prefix":"前綴", "suffix": "後綴", "gender": "性別", "birthdate": "出生日期", "state": "省份", "phoneid": "電話號碼", " nickname": "暱稱", "MiddleName": "中間名", "thumbnailimageurl": "圖片網址", "imageurl": "圖片網址", "hometown": "家鄉", "industry": "行業", "about": "Acerca", "timezone": "所處時區", "mainAddress": "主要住址", "localCity": "現處城市", "localCountry": "現處國家", "profileCountry" : "Perfil del país", "relationshipStatus": "婚姻狀況", "religion":"信仰", "political": "政治傾向", "firstname": "名", "username": "用戶名", "country": "國家", "city": "城市", "company": "公司"},
      "placeholders": { "emailid": "郵箱地址", "password": "密碼", "confirmpassword": "確認密碼"},
      "validationMessages": [
      { "rule": "required", "message": "您需要輸入%s。" },
      { "rule": "valid_email", "message": " %s必須包含有效的電子郵件地址。" },
      {   "rule":  "min_length  ",   "message":  "%s必須包含至少6位數。"  },
      {   "rule":  "matches",   "message":  "%s不符合"  }
      ],
      "errorMessages": [
      { "code": 966, "message": "您輸入的用戶名或密碼不正確", "description": "您輸入的用戶名或密碼不正確，請輸入正確的用戶名密碼組合" },
      { "code": 967, "message": "您輸入的電子郵箱不是正確的格式", "description": "您輸入的電子郵箱不是正確的格式" },
      { "code": 901, "message": "您輸入的API密碼不正確", "description": "你提供LoginRadius 的API密碼不正確或者已經失效，請使用有效的API密碼或者登陸您的LoginRadius賬戶驗證您的API密碼。" },
      { "code": 938,   "message":  "用戶不存在", "description": "您輸入的用戶不存在，請使用一個有效的用戶或者重新創建一個用戶。"  },
      { "code": 966,   "message":  "無效的用戶名id和密碼", "description": "請使用一個有效的用戶名和密碼。"  },
      { "code": 967,   "message": "您輸入的密碼錯誤", "description": "您輸入的密碼錯誤，請重試。" },
      { "code": 970, "message": "您尚未驗證郵箱", "description": "您尚未驗證郵箱，請通過您郵件的鏈接驗證郵箱" },
      { "code": 974, "message": "郵箱驗證鏈接已經被使用", "description": "每個鏈接只能被使用一次，如果您已經成功驗證郵箱，您可以直接登錄，或者您可以用'忘記密碼'選項來重置密碼。" }
      ],
      "buttonsName":{
      "login": "登陸",
      "registration":"註冊",
      "forgotPassword": "發送",
      "resetPassword": "重置"
      },
      lscontent: {
        forgotPWgreet: "請登陸您的郵箱驗證",
        socialandloginDivider: "或者您可以使用",
        tabLabels: ["登陸", "註冊", "忘記密碼？"],
        socialblockLabel: "使用",
        resetpage: "重置密碼",
        signupandForgotPwrequest: "請登錄郵箱驗證",
        emailVerifiedMessage: "成功註冊"
      }
    }

    if(options.language) {
          options.content = window[options.language.toLowerCase()].lscontent;}

    LRObject.util.ready(function() {
        LRObject.loginScreen("distinct-container",options,cb);
        if(options.language) {
          LRObject.$hooks.call('setLocaleBasedInfo',window[options.language.toLowerCase()]);
        }

      })

    </script>
</html>