package practice.docs.spring.bean.scope;

import org.springframework.stereotype.Component;

@Component
public class Single {

    private final Proto proto;
    private final ProxyProto proxyProto;

    public Single(Proto proto, ProxyProto proxyProto) {
        this.proto = proto;
        this.proxyProto = proxyProto;
    }

    public Proto getProto() {
        return proto;
    }

    public ProxyProto getProxyProto() {
        return proxyProto;
    }
}
