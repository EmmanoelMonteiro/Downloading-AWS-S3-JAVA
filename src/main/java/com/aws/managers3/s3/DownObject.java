package com.aws.managers3.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import org.apache.commons.io.FileUtils;
import com.amazonaws.services.s3.model.S3ObjectInputStream;

import java.io.File;
import java.io.IOException;
import java.util.List;
/**
 * Responsável por baixar os documentos (objetos) contidos no bucket selecionado.
 */
public class DownObject {

    public static String listarObjetos(String bucket){
        /**
         * Recebe a lista dos objetos do bucket selecionado
         */
        List list = ListObjetos.getObjetos(bucket);
        /**
         * defaultClient()
         * Este método cria um cliente de serviço com a configuração padrão,
         * usando a cadeia de provedor padrão para carregar credenciais e a região AWS.
         * Ver documentação em:
         * https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/credentials.html
         * */
        final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
        for(int i=0; i < list.size(); i++){
            /**
             * O S3Object representa um objeto armazenado no Amazon S3.
             * Este objeto contém o conteúdo dos dados e os metadados
             * do objeto armazenados pelo Amazon S3, como tipo de conteúdo,
             * comprimento do conteúdo, etc.
             */
            S3Object s3object = s3.getObject(bucket, list.get(i).toString());
            /**
             * O método getObjectContent() é chamado para obter um objeto S3ObjectInputStream
             * que se comporta como um InputStream Java convencional.
             */
            S3ObjectInputStream inputStream = s3object.getObjectContent();
            try {
                /**
                 * O método copyInputStreamToFile converte o InputStream
                 * em um arquivo a ser salvo na máquina.
                 */
                FileUtils.copyInputStreamToFile(inputStream, new File("/tmp/AmazonS3/" + list.get(i).toString()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "Terminou o Download ###################";
    }
}
