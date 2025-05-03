package com.example.hackfest25

import com.google.auth.oauth2.GoogleCredentials
import java.io.ByteArrayInputStream
import java.io.IOException
import java.nio.charset.StandardCharsets

object AccessToken {

    private val firebaseMessagingScope = "https://www.googleapis.com/auth/firebase.messaging"
    fun getAccessToken() : String?
    {
        try {
            val jsonString = "{\n" +
                    "  \"type\": \"service_account\",\n" +
                    "  \"project_id\": \"hackfest-25-d1f0c\",\n" +
                    "  \"private_key_id\": \"928a52fa0b59f3aa4255c0939863808fea02a454\",\n" +
                    "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDsTy76kptLbAGj\\nu2tB5SCNWpj03XbXpBZLs36tEmd9CYtzNMRj+NQAOCNoD2i/eA4KYnjR272Ib/i/\\n2i76FS2cZomNGlVeLrk4zi7qtvJdqAKRSHPtcJlMzG1Jv6GZoymQMV4OQNVNZd5g\\nSVMNvfCsRQvlCGMIHgHK/VZAweGn+6kmBPFacqaoDSBuGl+rPn3QxNAxwJIq8X0W\\nw6PZ98eJnbPMW0gklwd/w7XfjQusbbB7Ag8ZO/BAoBPP2C9K+I8lXq+ofjXsDVxg\\n6q4B06+sdkET/zzs4AYpn597ErkDc8NXGw+wxu7YmHy9pc0jmqRDedrherPhtyCS\\n9qKvMeVRAgMBAAECgf9GibG8RNxA5zyWDfE2T5l9QviQHzYaUyCp+CptVHu6bIme\\nb2HaywEoD5nXYMIjup0g/G6UNhjytnnKIEFlj8IjAs3hu2VAIoengo7+q8gtAg8X\\neZ52geXrcW+DVBso1qDRf0BUK4Yq/v13lcD07n2o7p4I/+KPybqUnTU3Sf3R5k+m\\noC9OJnDvBH/0o7glX1a3xdbwpSu8jy2342mRPhBMmdF3UYaZGSadx0Q1SJfhJ/N0\\nOfWCcKy2j3kzWsAIt64lEXfjbK2UzDEoxU3RC/cVYtI2TYuX/FNkCP1CX60EJltR\\n8Of/wXFFDxFRjRjZhwZ1noF7jlBQQhWsYvK58rECgYEA+fybxQv/LcBPNgOu9pfI\\nRTu0shSHGxYWvu4mTTo90hOyXkhDifVC2xAgOSC6/eSEE5ZL3ztB0x11nnghYEaB\\n/0GetB8Dc0l8E5Tw/PDkuX8lLMnRi80DZ0dg8g5Xnu5vbjmj2VSsqXl0ULaX1Y/k\\n/CciZqoW1nzNbVw9YxjkE/kCgYEA8f5Zz5LXtOznvCm+S+xZhH5bBavujhcnhR2A\\ntEt02AISBklJvegA+/qfsUZUiKDUrzqpE/9BzVbcyDgvk1529fgibiR/1422Dpgs\\nn76FDKHzUWDvIfoR7tyRtsSSAHzk7sKTNXGdZfMY/dEOP+9rQfpbepNPVHq6BhPs\\nfOfkAhkCgYEAlNAIVmuG01BolunobIj8QiKBtYS8zKYAklYoXM6v4G+zPabc9bIX\\nw1o9JGTUi7FN4m8U6WVYEPm3e8ddbvdqCW6hr+3KWwXCo9GFB73LGpWSpq/ZWtSH\\nEyMNleptxIGBueb8H7LlOdnAIRAhIJORJ32QX/cesz4F9/Tx4hz+INkCgYEAiOX+\\nQspskyLOegkXaXYcsjKVJaE9RE7fAZROIjDpueV58up0+CUOoX4H507FNcHeb/78\\ndZ6ayCJSpkX6zCDNpZqpR6wIUpYNnzYBUKGEPUBFGQ2AWrVQfdNz73RGsFX3YQbc\\nJojOpUUgJz6kFBFKmTmblL1PTJhdMmEFEShSOckCgYEAhOsF6yd6I4woJlNS8SF+\\n7JiPivSj1ZpyNFfBK9t3I0JBMtGK7I079YpG85Gf/+KxSf8c3LXkpRNmbAfx+Q35\\nGnenI0vR2YScsL/Vd+DtHVnXpo+pZDMDAnnkyfrf35ybslpvUhFLi0mMgpOwOZAU\\nBKnWxhEJjBkPEwOzI96NNxE=\\n-----END PRIVATE KEY-----\\n\",\n" +
                    "  \"client_email\": \"firebase-adminsdk-fbsvc@hackfest-25-d1f0c.iam.gserviceaccount.com\",\n" +
                    "  \"client_id\": \"108614148855303613589\",\n" +
                    "  \"auth_uri\": \"https://accounts.google.com/o/oauth2/auth\",\n" +
                    "  \"token_uri\": \"https://oauth2.googleapis.com/token\",\n" +
                    "  \"auth_provider_x509_cert_url\": \"https://www.googleapis.com/oauth2/v1/certs\",\n" +
                    "  \"client_x509_cert_url\": \"https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-fbsvc%40hackfest-25-d1f0c.iam.gserviceaccount.com\",\n" +
                    "  \"universe_domain\": \"googleapis.com\"\n" +
                    "}\n"

            val stream = ByteArrayInputStream(jsonString.toByteArray(StandardCharsets.UTF_8))

            val googleCredential = GoogleCredentials.fromStream(stream)
                .createScoped(arrayListOf(firebaseMessagingScope))

            googleCredential.refresh()

            return googleCredential.accessToken.tokenValue
        }catch (e : IOException)
        {
            return null
        }
    }
}