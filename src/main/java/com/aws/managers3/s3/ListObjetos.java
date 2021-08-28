package com.aws.managers3.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import java.util.ArrayList;
import java.util.List;
/**
 * Responsável por listar os objetos que existirem no bucket selecionado.
 */
public class ListObjetos {

    public static List getObjetos(String bucket){
        List objs = new ArrayList<>();
        /**
         * defaultClient()
         * Este método cria um cliente de serviço com a configuração padrão,
         * usando a cadeia de provedor padrão para carregar credenciais e a região AWS.
         * Ver documentação em:
         * https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/credentials.html
         * */
        final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
        ObjectListing objectListing = s3.listObjects(bucket);
        for (S3ObjectSummary os : objectListing.getObjectSummaries()) {
            objs.add(os.getKey());
        }
        return objs;
    }

}
