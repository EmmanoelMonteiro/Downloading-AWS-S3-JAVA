package com.aws.managers3.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;

import java.util.List;
/**
 * Responsável por listar os buckets disponíveis na conta do S3 na AWS.
 */
public class ListBuckets {

    public static List<Bucket> listBuckets() {
        /**
         * defaultClient()
         * Este método cria um cliente de serviço com a configuração padrão,
         * usando a cadeia de provedor padrão para carregar credenciais e a região AWS.
         * Ver documentação em:
         * https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/credentials.html
         * */
        final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
        List<Bucket> buckets = s3.listBuckets();
        //Caso queira listar no terminal os Buckets existentes na conta.
        /*
        System.out.print("Lista de Buckets do S3 da AWS:\n");
        for (Bucket b : buckets){
            System.out.println(b);
        }
        */
        return buckets;
    }
}
