(ns hbase-region-inspector.hbase.base
  (:import [org.apache.hadoop.hbase
            RegionLoad]
           [org.apache.hadoop.hbase.client
            RegionInfo]))

(defn info->map
  "Builds map from HRegionInfo"
  [info]
  {:encoded-name (.getEncodedName ^RegionInfo info)
   ; :table
   :start-key    (.getStartKey ^RegionInfo info)
   :end-key      (.getEndKey ^RegionInfo info)
   :meta?        (.isMetaRegion ^RegionInfo info)})

(defn load->map
  "Builds map from RegionLoad"
  [load]
  {:compacted-kvs              (.getCurrentCompactedKVs ^RegionLoad load)
   :memstore-size-mb           (.getMemStoreSizeMB ^RegionLoad load)
   :read-requests              (.getReadRequestsCount ^RegionLoad load)
   :requests                   (.getRequestsCount ^RegionLoad load)
   :root-index-size-kb         (.getRootIndexSizeKB ^RegionLoad load)
   :store-file-index-size-mb   (.getStorefileIndexSizeMB ^RegionLoad load)
   :store-files                (.getStorefiles ^RegionLoad load)
   :store-file-size-mb         (.getStorefileSizeMB ^RegionLoad load)
   :stores                     (.getStores ^RegionLoad load)
   ; :store-uncompressed-size-mb
   :total-compacting-kvs       (.getTotalCompactingKVs ^RegionLoad load)
   :bloom-size-kb              (.getTotalStaticBloomSizeKB ^RegionLoad load)
   :total-index-size-kb        (.getTotalStaticIndexSizeKB ^RegionLoad load)
   :write-requests             (.getWriteRequestsCount ^RegionLoad load)})

