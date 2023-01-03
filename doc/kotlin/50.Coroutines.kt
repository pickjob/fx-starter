//
// CoroutineScope: 协程范围
//      创建:
//          fun CoroutineScope(context: CoroutineContext): CoroutineScope
//          fun MainScope(): CoroutineScope
//      Scope builder
//          runBlocking: 阻塞当前线程, 普通函数
//              fun <T> runBlocking(
//                  context: CoroutineContext = EmptyCoroutineContext,
//                  block: suspend CoroutineScope.() -> T
//              ): T
//          coroutineScope: 释放当前线程, 仍是 suspend function
//              suspend fun <R> coroutineScope(block: suspend CoroutineScope.() -> R): R
//      扩展方法:
//          val CoroutineScope.isActive: Boolean 结束标志
//          fun CoroutineScope.launch(
//              context: CoroutineContext = EmptyCoroutineContext,
//              start: CoroutineStart = CoroutineStart.DEFAULT,
//              block: suspend CoroutineScope.() -> Unit
//          ): Job
//          fun CoroutineScope.cancel(cause: CancellationException? = null)
//
// Suspend function
//      延迟
//          suspend fun delay(duration: Duration)
//      返回当前 CoroutineContext
//          suspend fun currentCoroutineContext(): CoroutineContext
//      释放时间片
//          suspend fun yield()
//      取消并等待
//          suspend fun Job.cancelAndJoin()
//      超时抛异常 TimeoutCancellationException
//          suspend fun <T> withTimeout(timeMillis: Long, block: suspend CoroutineScope.() -> T): T
//      超时返回
//          suspend fun <T> withTimeoutOrNull(timeMillis: Long, block: suspend CoroutineScope.() -> T): T?
//
// CoroutineDispatcher: CoroutineContext 实现
//      fun newSingleThreadContext(name: String): CloseableCoroutineDispatcher
//      fun newFixedThreadPoolContext(nThreads: Int, name: String): CloseableCoroutineDispatcher
//      Dispatchers
//          Dispatchers.Default: 默认
//          Dispatchers.IO
//          Dispatchers.Main
//          Dispatchers.Unconfined: 主线程