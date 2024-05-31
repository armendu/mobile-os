package com.example.plantapp.api

import com.google.gson.annotations.SerializedName

data class PlantDataResponse(
    @SerializedName("data") var data: ArrayList<Data> = arrayListOf(),
    @SerializedName("links") var links: Links? = Links(),
    @SerializedName("meta") var meta: Meta? = Meta()
)

data class Links(
    @SerializedName("self") var self: String? = null,
    @SerializedName("plant") var plant: String? = null,
    @SerializedName("genus") var genus: String? = null
)

data class Data(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("common_name") var commonName: String? = null,
    @SerializedName("slug") var slug: String? = null,
    @SerializedName("scientific_name") var scientificName: String? = null,
    @SerializedName("year") var year: Int? = null,
    @SerializedName("bibliography") var bibliography: String? = null,
    @SerializedName("author") var author: String? = null,
    @SerializedName("status") var status: String? = null,
    @SerializedName("rank") var rank: String? = null,
    @SerializedName("family_common_name") var familyCommonName: String? = null,
    @SerializedName("genus_id") var genusId: Int? = null,
    @SerializedName("image_url") var imageUrl: String? = null,
    @SerializedName("synonyms") var synonyms: ArrayList<String> = arrayListOf(),
    @SerializedName("genus") var genus: String? = null,
    @SerializedName("family") var family: String? = null,
    @SerializedName("links") var links: Links? = Links()
)

data class Meta(

    @SerializedName("total") var total: Int? = null

)