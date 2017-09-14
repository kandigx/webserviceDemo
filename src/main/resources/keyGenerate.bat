keytool -genkey -alias ciecc -keypass Hfzx7bx5B7GqQALUnRao3B612QNq0pAP -keyalg RSA -keysize 1024 -validity 3650 -keystore privatestore.jks -storepass keyStorePassword -dname "cn=ciecc"
keytool -selfcert -alias ciecc -keystore privatestore.jks -storepass keyStorePassword -keypass Hfzx7bx5B7GqQALUnRao3B612QNq0pAP
keytool -importkeystore -alias ciecc -deststorepass keyStorePassword -destkeypass Hfzx7bx5B7GqQALUnRao3B612QNq0pAP -destkeystore publicstore.jks -srckeystore privatestore.jks -srcstorepass keyStorePassword

