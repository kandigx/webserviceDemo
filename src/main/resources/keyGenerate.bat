keytool -genkey -alias ciecc -keypass cieccPassword -keyalg RSA -keysize 1024 -validity 3650 -keystore privatestore.jks -storepass keyStorePassword -dname "cn=ciecc" 
keytool -selfcert -alias ciecc -keystore privatestore.jks -storepass keyStorePassword -keypass cieccPassword
keytool -importkeystore -alias ciecc -deststorepass keyStorePassword -destkeypass cieccPassword -destkeystore publicstore.jks -srckeystore privatestore.jks -srcstorepass keyStorePassword

