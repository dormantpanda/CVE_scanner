package com.example.possible_vulnerabilities;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JSONApi {
    @GET("/json-feed.php")
    public Call<List<CVE>> getCveList(@Query("numrows") String numrows,
                                      @Query("vendor_id") String vendorId,
                                      @Query("product_id") String productId,
                                      @Query("version_id") Integer versionId);
}
