package com.yutu.util;
 
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yutu.configuration.SystemPropertiesConfig;
import com.yutu.entity.ConfigConstants;
import redis.clients.jedis.*;


public class JedisPoolUtils{
        private static String JEDIS_IP;
        private static int JEDIS_PORT;
        private static String JEDIS_PASSWORD;
        private static JedisPool jedisPool;
        static {
            JEDIS_IP= SystemPropertiesConfig.System_Redis_Host;
            JEDIS_PORT=Integer.parseInt(SystemPropertiesConfig.System_Redis_Host);
            JEDIS_PASSWORD=SystemPropertiesConfig.System_Redis_Host;
            JedisPoolConfig config=new JedisPoolConfig();
           //config.setMaxActive(5000);
            config.setMaxIdle(256);
            //config.setMaxWait(5000L);
            config.setTestOnBorrow(true);
            config.setTestOnReturn(true);
            config.setTestWhileIdle(true);
            config.setMinEvictableIdleTimeMillis(60000L);
            config.setTimeBetweenEvictionRunsMillis(3000L);
            config.setNumTestsPerEvictionRun(-1);
            jedisPool=new JedisPool(config,JEDIS_IP,JEDIS_PORT,60000,JEDIS_PASSWORD);
        }
        
        /**
         * 根据key获得数据
         * @param key
         * @return 字符串
         * @author:zhaobc
         * @creatTime:2019年2月18日 - 下午2:20:44
         */
        public static String get(String key){
            String value=null;
            Jedis jedis=null;
            try{
                jedis=jedisPool.getResource();
                value=jedis.get(key);
            }catch (Exception e){
            	jedis.close();
                e.printStackTrace();
            }finally {
                close(jedis);
            }
            return value;
        }

        /**
         *【方法重载】 字符串流形式设置数据
         * @param key
         * @param value
         * @return 字符串
         * @author:zhaobc
         * @creatTime:2019年2月18日 - 下午2:26:42
         */
        public static void set(String key, String value) {
            Jedis jedis = null;
            try {
                jedis = jedisPool.getResource();
                jedis.set(key, value);
            } catch (Exception e) {
                //释放redis对象
                jedis.close();
                e.printStackTrace();
            } finally {
                //返还到连接池
                close(jedis);
            }
        }
        
        
       /**
        * 释放redis资源
        * @param jedis
        * @author:zhaobc
        * @creatTime:2019年2月18日 - 下午2:21:39
        */
        private static void close(Jedis jedis) {
            try{
            	jedis.close();
            }catch (Exception e){
                if(jedis.isConnected()){
                    jedis.quit();
                    jedis.disconnect();
                }
            }
        }
        
        
        
        /**
         * 【方法重载】字节流形式获取数据
         * @param key
         * @return
         * @author:zhaobc
         * @creatTime:2019年2月18日 - 下午2:23:35
         */
        public static byte[] get(byte[] key){
            byte[] value = null;
            Jedis jedis = null;
            try {
                jedis = jedisPool.getResource();
                value = jedis.get(key);
            } catch (Exception e) {
                //释放redis对象
                jedis.close();
                e.printStackTrace();
            } finally {
                //返还到连接池
                close(jedis);
            }

            return value;
        }

        /**
         *【方法重载】 字节流形式设置数据
         * @param key
         * @param value
         * @author:zhaobc
         * @creatTime:2019年2月18日 - 下午2:26:42
         */
        public static void set(byte[] key, byte[] value) {
            Jedis jedis = null;
            try {
                jedis = jedisPool.getResource();
                jedis.set(key, value);
            } catch (Exception e) {
                //释放redis对象
                jedis.close();
                e.printStackTrace();
            } finally {
                //返还到连接池
                close(jedis);
            }
        }

        /**
         * 【字节】根据key删除数据
         * @param key
         * @author:zhaobc
         * @creatTime:2019年2月18日 - 下午4:10:09
         */
        public static void del(byte[] key) {
            Jedis jedis = null;
            try {
                jedis = jedisPool.getResource();
                jedis.del(key);
            } catch (Exception e) {
                //释放redis对象
                jedis.close();
                e.printStackTrace();
            } finally {
                //返还到连接池
                close(jedis);
            }
        }
        
        
        /**
         * 【字符串】根据key删除数据
         * @param key
         * @author:zhaobc
         * @creatTime:2019年2月18日 - 下午4:10:09
         */
        public static void del(String key) {
            Jedis jedis = null;
            try {
                jedis = jedisPool.getResource();
                jedis.del(key);
            } catch (Exception e) {
                //释放redis对象
                jedis.close();
                e.printStackTrace();
            } finally {
                //返还到连接池
                close(jedis);
            }
        }
       
        
/*--------一下是哈希函数操作redis 需要进行深入研究--------------------*/   
        
        /**
         * 存储字节类型的哈希数据
         * @param key
         * @param field
         * @param value
         * @author:zhaobc
         * @creatTime:2019年2月18日 - 下午2:37:06
         */
        public static void hset(byte[] key, byte[] field, byte[] value) {
            Jedis jedis = null;
            try {
                jedis = jedisPool.getResource();
                jedis.hset(key, field, value);
            } catch (Exception e) {
                //释放redis对象
                jedis.close();
                e.printStackTrace();
            } finally {
                //返还到连接池
                close(jedis);
            }
        }

        /**
         * 存储字符串类型的哈希数据
         * @param key
         * @param field
         * @param value
         * @author:zhaobc
         * @creatTime:2019年2月18日 - 下午2:37:52
         */
        public static void hset(String key, String field, String value) {
            Jedis jedis = null;
            try {
                jedis = jedisPool.getResource();
                jedis.hset(key, field, value);
            } catch (Exception e) {
                //释放redis对象
                jedis.close();
                e.printStackTrace();
            } finally {
                //返还到连接池
                close(jedis);
            }
        }

        /**
         * 获得字符串类型的哈希数据
         * @param key
         * @param field
         * @return
         * @author:zhaobc
         * @creatTime:2019年2月18日 - 下午2:39:30
         */
        public static String hget(String key, String field) {

            String value = null;
            Jedis jedis = null;
            try {
                jedis = jedisPool.getResource();
                value = jedis.hget(key, field);
            } catch (Exception e) {
                //释放redis对象
                jedis.close();
                e.printStackTrace();
            } finally {
                //返还到连接池
                close(jedis);
            }

            return value;
        }
        
        /**
         * 获取字节类型的哈希数据
         * @param key
         * @param field
         * @return
         * @author:zhaobc
         * @creatTime:2019年2月18日 - 下午2:39:52
         */
        public static byte[] hget(byte[] key, byte[] field) {

            byte[] value = null;
            Jedis jedis = null;
            try {
                jedis = jedisPool.getResource();
                value = jedis.hget(key, field);
            } catch (Exception e) {
                //释放redis对象
                jedis.close();
                e.printStackTrace();
            } finally {
                //返还到连接池
                close(jedis);
            }

            return value;
        }
        
        /**
         * 删除指定的字节类型的哈希数据
         * @param key
         * @param field
         * @author:zhaobc
         * @creatTime:2019年2月18日 - 下午2:40:32
         */
        public static void hdel(byte[] key, byte[] field) {

            Jedis jedis = null;
            try {
                jedis = jedisPool.getResource();
                jedis.hdel(key, field);
            } catch (Exception e) {
                //释放redis对象
                jedis.close();
                e.printStackTrace();
            } finally {
                //返还到连接池
                close(jedis);
            }
        }
        
        
/*------------------------------队列操作-------------------------------- */       

        /**
         * 查询队列数量
         * @param key 设置key 
         * @author:zhaobc
         * @creatTime:2019年2月18日 - 下午2:42:08
         */
        public static long getLen(String key) {
            Jedis jedis = null;
            long  pushLen=0;
            try {
                jedis = jedisPool.getResource();
                pushLen=jedis.llen(key);
            } catch (Exception e) {
                //释放redis对象
                jedis.close();
                e.printStackTrace();
            } finally {
                //返还到连接池
                close(jedis);
            }
            return pushLen;
        }
        

        /**
         * 【正循】存储REDIS队列 顺序存储字节类型数据
         * @param key 设置key
         * @param value  数值
         * @author:zhaobc
         * @creatTime:2019年2月18日 - 下午2:42:08
         */
        public static long lpush(String key, String value) {
            long returnNum=0;
            Jedis jedis = null;
            try {
                jedis = jedisPool.getResource();
                returnNum=jedis.lpush(key, value);
            } catch (Exception e) {
                //释放redis对象
                jedis.close();
                e.printStackTrace();
            } finally {
                //返还到连接池
                close(jedis);
            }
            return returnNum;
        }

        
        
        /**
         * 【反序】存储REDIS队列 反向存储字节类型数据
         * @param key
         * @param value
         * @author:zhaobc
         * @creatTime:2019年2月18日 - 下午2:43:15
         */
        public static void rpush(String key, String value) {
            Jedis jedis = null;
            try {
                jedis = jedisPool.getResource();
                jedis.rpush(key, value);

            } catch (Exception e) {
                //释放redis对象
                jedis.close();
                e.printStackTrace();

            } finally {
                //返还到连接池
                close(jedis);

            }
        }

       
        
        /**
         * 【先进后出】获取队列字节类型数据 
         * @param key
         * @return
         * @author:zhaobc
         * @creatTime:2019年2月18日 - 下午2:45:36
         */
         public static String lpop(String key) {
        	 String bytes = null;
             Jedis jedis = null;
             try {
                 jedis = jedisPool.getResource();
                 bytes = jedis.lpop(key);
             } catch (Exception e) {
                 //释放redis对象
                 jedis.close();
                 e.printStackTrace();
             } finally {
                 //返还到连接池
                 close(jedis);
             }
             return bytes;
         }

        
       /**
        * 【先进先出】获取队列字节类型数据 
        * @param key
        * @return
        * @author:zhaobc
        * @creatTime:2019年2月18日 - 下午2:45:36
        */
        public static String rpop(String key) {
        	String bytes = null;
            Jedis jedis = null;
            try {
                jedis = jedisPool.getResource();
                bytes = jedis.rpop(key);
            } catch (Exception e) {
                //释放redis对象
                jedis.close();
                e.printStackTrace();
            } finally {
                //返还到连接池
                close(jedis);
            }
            return bytes;
        }
        
        
       /* -----------redis 高级操作 暂时不做研究  先保留---------------*/
        public static void hmset(Object key, Map hash) {
            Jedis jedis = null;
            try {
                jedis = jedisPool.getResource();
                jedis.hmset(key.toString(), hash);
            } catch (Exception e) {
                //释放redis对象
                jedis.close();
                e.printStackTrace();

            } finally {
                //返还到连接池
                close(jedis);

            }
        }
        
    
        public static List hmget(Object key, String... fields) {
            List result = null;
            Jedis jedis = null;
            try {

                jedis = jedisPool.getResource();
                result = jedis.hmget(key.toString(), fields);

            } catch (Exception e) {
                //释放redis对象
                jedis.close();
                e.printStackTrace();

            } finally {
                //返还到连接池
                close(jedis);

            }
            return result;
        }

        public static Set hkeys(String key) {
            Set result = null;
            Jedis jedis = null;
            try {
                jedis = jedisPool.getResource();
                result = jedis.hkeys(key);

            } catch (Exception e) {
                //释放redis对象
                jedis.close();
                e.printStackTrace();

            } finally {
                //返还到连接池
                close(jedis);

            }
            return result;
        }
        public static List lrange(byte[] key, int from, int to) {
            List result = null;
            Jedis jedis = null;
            try {
                jedis = jedisPool.getResource();
                result = jedis.lrange(key, from, to);

            } catch (Exception e) {
                //释放redis对象
                jedis.close();
                e.printStackTrace();
            } finally {
                //返还到连接池
                close(jedis);
            }
            return result;
        }
        public static Map hgetAll(byte[] key) {
            Map result = null;
            Jedis jedis = null;
            try {
                jedis = jedisPool.getResource();
                result = jedis.hgetAll(key);
            } catch (Exception e) {
                //释放redis对象
                jedis.close();
                e.printStackTrace();

            } finally {
                //返还到连接池
                close(jedis);
            }
            return result;
        }

      

        public static long llen(byte[] key) {
            long len = 0;
            Jedis jedis = null;
            try {
                jedis = jedisPool.getResource();
                jedis.llen(key);
            } catch (Exception e) {
                //释放redis对象
                jedis.close();
                e.printStackTrace();
            } finally {
                //返还到连接池
                close(jedis);
            }
            return len;
    }
}