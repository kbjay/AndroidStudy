.class public Lcom/kbjay/decompile/hook/log/LogDecode;
.super Ljava/lang/Object;
.source "LogDecode.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static logParamsAndReturn(J)Ljava/lang/String;
    .registers 4
    .param p0, "j"    # J

    .prologue
    .line 7
    invoke-static {p0, p1}, Lcom/kbjay/decompile/hook/log/InjectLog;->printLong(J)V

    .line 8
    invoke-static {p0, p1}, Lcom/kbjay/decompile/hook/log/LogDecode;->test(J)Ljava/lang/String;

    move-result-object v0

    .line 9
    .local v0, "test":Ljava/lang/String;
    invoke-static {v0}, Lcom/kbjay/decompile/hook/log/InjectLog;->printString(Ljava/lang/String;)V

    .line 10
    return-object v0
.end method

.method public static test(J)Ljava/lang/String;
    .registers 4
    .param p0, "j"    # J

    .prologue
    .line 14
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p0, p1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
