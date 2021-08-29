# Downloading-AWS-S3-JAVA
API que Baixa arquivos do AWS S3 com JAVA e Spring Boot

## OBJETIVO
Conectar ao serviço do S3 da AWS utilizando o Spring Boot com JAVA para baixar  todo o conjunto de objetos de um bucket.

## ORIENTAÇÕES DE CONFIGURAÇÃO

### Segurança das credenciais da AWS:

Utilizei as orientações da AWS para criar a pasta ~/.aws/ e colocar os arquivos de **credentials** e  **config** dentro desta pasta. <br />
Link: _https://docs.aws.amazon.com/pt_br/sdk-for-java/v1/developer-guide/credentials.html_

#### config

> [default]
> region = us-east-2

#### credentials

> [default]
> aws_access_key_id = SUAkeyid <br/>
> aws_secret_access_key =  suasecretkey

### Gerenciar as dependências
Para gerenciar as dependências de operações com a AWS utilizei o Maven colocando a seguinte referencia:

		<dependency>
			<groupId>com.amazonaws</groupId>
			<artifactId>aws-java-sdk</artifactId>
			<version>1.12.54</version>
		</dependency>

Para execução do projeto se faz necessário:

* Java 11 ou versões superiores.
* Apache Maven 3.6.0

### application.properties
Neste arquivo você vai poder indicar o bucket que será trabalhado nos métodos de operação.

> services.s3.bucket = teste0111

## PRINCIPAIS MÉTODOS

- /TestBucket <br />
_Testa se a referência do bucket está funcionando para o application.properties_
- /Download <br />
_Realiza o download dos arquivos que estiverem dentro do bucket_
- /ListBuckets <br />
_Lista os buckets que existirem na conta do S3 da AWS._
- /ListObjects <br />
_Lista os objetos que estão disponíveis no bucket._
