# Instruções de configuração da biblioteca CDDL no projeto

Ao usar a bilioteca disponibilizada em libs/cddl-desktop-1.0.0-jar-with-dependencies.jar, não é necessário incluir no pom.xml nenhuma dependência.

Se for usar o cddl-desktop-1.0.0.jar a partir do repositório do lsdi, deve ser incluído no pom.xml o seguinte:

- O repositório do lsdi:

```
<repositories>
    <repository>
        <id>central</id>
        <name>dali-server-releases</name>
        <url>http://lsdi.ufma.br:8081/artifactory/libs-release-local</url>
    </repository>
</repositories>
```
    
- As dependências:
    
```
<dependency>
    <groupId>br.ufma.lsdi</groupId>
    <artifactId>cddl-desktop</artifactId>
    <version>1.0.0</version>
</dependency>
<dependency>
    <groupId>org.eclipse.paho</groupId>
    <artifactId>org.eclipse.paho.client.mqttv3</artifactId>
    <version>1.2.2</version>
</dependency>
<dependency>
    <groupId>com.lmax</groupId>
    <artifactId>disruptor</artifactId>
    <version>3.3.0</version>
</dependency>
<dependency>
    <groupId>org.mapdb</groupId>
    <artifactId>mapdb</artifactId>
    <version>1.0.6</version>
</dependency>
<dependency>
    <groupId>io.netty</groupId>
    <artifactId>netty-all</artifactId>
    <version>4.0.25.Final</version>
</dependency>
<dependency>
    <groupId>org.greenrobot</groupId>
    <artifactId>eventbus</artifactId>
    <version>3.2.0</version>
</dependency>
<dependency>
    <groupId>com.espertech</groupId>
    <artifactId>esper</artifactId>
    <version>7.1.0</version>
</dependency>
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-lang3</artifactId>
    <version>3.9</version>
</dependency>
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.6</version>
</dependency>
```
O projeto demo está configurado para usar a biblioteca do repositório. Caso deseje usar a biblioteca da pasta lib, pode-se remover todas as dependências acima do arquivo pom.xml.# cddl-desktop-demo-luis
