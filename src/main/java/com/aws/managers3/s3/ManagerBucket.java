package com.aws.managers3.s3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * Classe gerenciadora das ações que podem ser acionadas na API.
 */
@RestController
public class ManagerBucket {

    /**
     * Referencia o bucket que esta configurado no application.properties
     */
    @Value("${services.s3.bucket}")
    private String bucket;
    /**
     * Testa se a referencia do bucket esta funcionando para o application.properties
     */
    @GetMapping("/testBucket")
    public String getBucket(){
        return bucket;
    }
    /**
     * Realiza o download dos arquivos que estiverem dentro do bucket
     */
    @GetMapping("/download")
    public String downObject(){
        String list = DownObject.listarObjetos(bucket);
        return list;
    }
    /**
     * Lista os buckets que existirem na conta do S3 da AWS.
     */
    @GetMapping("/ListBuckets")
    public List ListBuckets(){
        List list = ListBuckets.listBuckets();
        return list;
    }
    /**
     * Lista os objetos que estão disponíveis no bucket.
     */
    @GetMapping("/ListObjects")
    public List ListObjects(){
        List list = ListObjetos.getObjetos(bucket);
        return list;
    }
}
