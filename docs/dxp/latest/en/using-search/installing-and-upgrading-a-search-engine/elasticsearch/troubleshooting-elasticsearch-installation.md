# Troubleshooting Elasticsearch Installation

If you've set up [Liferay with Elasticsearch](./getting-started-with-elasticsearch.md) in remote mode but Liferay isn't connecting to Elasticsearch, check these things.

## Cluster Name

The value of the `cluster.name` property in `elasticsearch.yml` must match the `clusterName` property configured in the Liferay Elasticsearch connector.

## Transport Addresses

The value of the `transportAddresses` property in the Elasticsearch connector configuration must contain at least one valid host and port where an Elasticsearch node is running. If Liferay is running in embedded mode and you start a standalone Elasticsearch node or cluster, it detects that port `9300` is taken and switches to port `9301`. If you then set Liferay's Elasticsearch connector to remote mode, it continues to look for Elasticsearch at the default port (`9300`). Make sure to list all master and data node addresses of the cluster.

[Connecting to Elasticsearch](./connecting-to-elasticsearch.md) covers the connector configuration options in more detail.

## Network Host Addresses

In Liferay 7.3+, the bundled Elasticsearch server (sidecar) runs on port `9201` by default. This means that setting the `networkHostAddress` of your remote Elasticsearch installation using Elasticsearch's default HTTP port (`9200`) will not cause a conflict. As with the transport addresses, make sure to list all master and data node addresses of the cluster.

## Cluster Sniffing (Additional Configurations)

Elasticsearch clusters can have multiple node [types](https://www.elastic.co/guide/en/elasticsearch/reference/7.x/modules-node.html#modules-node).  [Cluster sniffing](https://www.elastic.co/guide/en/elasticsearch/client/java-api/7.x/transport-client.html), enabled by default in the Elasticsearch connector, looks for `data` nodes configured in the `transportAddresses` property. If none are available, the connector may throw a `NoNodeAvailableException` in the console log. If cluster sniffing is to remain enabled, avoid this error by configuring at least one `data` node's transport address to be "sniffable" at all times.

To disable cluster sniffing, add `clientTransportSniff=false` to the `.config` file or unselect the Client Transport Sniff property in System Settings.

## [Docker] Connection Refused

The Liferay DXP container must recognize the Elasticsearch IP to establish a connection. Add `/etc/hosts/` entries that map the Elasticsearch container name to the Elasticsearch server host IP address. This can be established during the `docker run` phase by passing an argument like this:

```bash
--add-host elasticsearch:[IP address]
```

To obtain the IP addresses of all running containers, run 

```bash
docker network inspect bridge
```

## Configuration File Names

If you are experiencing any problem connecting Liferay to Elasticsearch (perhaps seeing `NoNodeAvailableException` messages in the Liferay log), one of the first steps to take is to make absolutely sure that the configuration files are named properly. Unrecognizable configuration files aren't processed. Resulting errors can vary.

## Disable Elasticsearch Deprecation Logging

Sometimes, Elasticsearch APIs used by Liferay's Elasticsearch connectors are deprecated. Even when there's no impact to the functionality required by Liferay, warning log messages can result:

```
[2019-07-16T14:47:05,779][WARN ][o.e.d.c.j.Joda           ] [
ode_name]'y' year should be replaced with 'u'. Use 'y' for year-of-era. Prefix your date format with '8' to use the new specifier.
[2019-07-16T14:47:06,007][WARN ][o.e.d.c.s.Settings       ] [
ode_name][xpack.ssl.certificate] setting was deprecated in Elasticsearch and will be removed in a future release! See the breaking changes documentation for the next major version.
[2019-07-16T14:47:06,007][WARN ][o.e.d.c.s.Settings       ] [
ode_name][xpack.ssl.certificate_authorities] setting was deprecated in Elasticsearch and will be removed in a future release! See the breaking changes documentation for the next major version.
[2019-07-16T14:47:06,008][WARN ][o.e.d.c.s.Settings       ] [
ode_name][xpack.ssl.key] setting was deprecated in Elasticsearch and will be removed in a future release! See the breaking changes documentation for the next major version.
[2019-07-16T14:47:06,463][WARN ][o.e.d.x.c.s.SSLService   ] [
ode_name]SSL configuration [xpack.http.ssl] relies upon fallback to another configuration for [key configuration, trust configuration], which is deprecated.
[2019-07-16T14:47:06,464][WARN ][o.e.d.x.c.s.SSLService   ] [
ode_name]SSL configuration [xpack.security.transport.ssl.] relies upon fallback to another configuration for [key configuration, trust configuration], which is deprecated.
1. 07-16T14:47:05,779][WARN ][o.e.d.c.j.Joda           ] [
```

These warnings do not signal any functional issues and can be disabled (see [Deprecation Logging](https://www.elastic.co/guide/en/elasticsearch/reference/7.x/logging.html#deprecation-logging) to learn how).
