package com.indipage.presentation.article

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.core_ui.base.BindingFragment
import com.example.core_ui.fragment.snackBar
import com.example.core_ui.fragment.toast
import com.indipage.R
import com.indipage.databinding.FragmentArticleDetailBinding

class ArticleDetailFragment : BindingFragment<FragmentArticleDetailBinding>(R.layout.fragment_article_detail) {

    private val testString =
        "<title>여러분은 글을 읽고, 쓰는 행위를 얼마나 가까이 하고 계신가요?</title>저는 요즘 심각한 집중력 부족 현상을 겪고 있어 얼마 전부터 ‘필사’\uD83D\uDCDD를 시작했어요. 매일 밤 잠들기 전 침대 머리맡에 등을 기대고 앉아 책을 2~3페이지씩 필사를 한답니다. 3주쯤 되어가는 것 같은데, 기분 탓인지 집중력이 꽤 많이 회복된 것 같아요. 전에는 책 1페이지를 읽으면서 휴대전화를 4~5번은 열어보았는데, 요즘은 금방 몰입해서 수십페이지를 한 호흡에 읽게 됐어요. <img>https://github.com/Indipage/ANDROID/assets/98076050/1043de78-a9cc-422a-8229-dc0f12d6c882</img>사실 이 문제의 가장 확실한 해결책은 독서와 글쓰기일테죠?\n<bold>문학살롱 초고</bold>는 읽고 쓰는 행위에 익숙하지 않은 사람들에게도, 읽고 쓰는 행위를 즐기는 사람들에게도 안성맞춤인 공간이에요. 포털 사이트에 이 공간은 <bold>‘책과 술로 사람을 만나는 공간, 읽고 쓰는 사람들을 위한 아지트’</bold>라고 소개되어 있죠.\n조용한 주택가에 가까운 합정동의 어느 골목에 위치한 초고는 ‘아지트’란 단어가 정말 잘 어울리는 공간이에요. 지하로 내려가는 계단을 지나 좁고 어두운 통로를 지나면 마치 시공간을 뛰어넘은 것처럼 약간은 몽롱하고 아늑한 느낌이 드는 공간이 나타나죠. 조도가 낮아 차분한 가운데 독서에 불편함이 없게 밝혀진 등이 반짝\uD83D\uDCA1거리고, 높은 천장엔 조금씩 빛이 새어들어오는 창문이 있고, 적당한 볼륨으로 신경을 거스르지 않는 음악이 흐르는 매력적인 공간. 그 분위기에 취해 저절로 책을 읽고, 글을 쓰고 싶어지는 공간이에요.<img>https://github.com/Indipage/ANDROID/assets/98076050/27b9bb2b-5f64-4033-bf58-0881c33cd068</img><title>책의 맛과 향이 담긴 칵테일</title>초고를 대표하는 또 한가지는 바로 \uD83C\uDF79<color><bold><click>문학 칵테일</click></bold></color>이에요. 초고는 일정 주기로 문학 작품을 담아낸 칵테일을 메뉴로 선보이고 있는데요. 새로운 메뉴가 탄생하면 시음회도 진행하고, SNS 콘텐츠로 작품과 함께 소개를 하기도 해요. 문학 칵테일을 주문하면 해당 칵테일의 모티브가 된 작품이 담긴 책이 칵테일과 함께 나와요. 칵테일을 한 모금 머금고 그 맛과 향을 음미하면서 작품을 읽어보면 평소엔 쉽게 느끼지 못했던 공감각이 확장되는 경험을 할 수 있어요. 작품의 어떤 매력과 특징이 칵테일의 맛과 향, 색깔로 표현되었는지 생각해보는 것도 흥미로웠고요\uD83D\uDE0D!<img>https://github.com/Indipage/ANDROID/assets/98076050/3784a091-34d4-4aab-a539-8eb3b67b05cd</img>평균 연령 25.6세의 초고즈가 온갖 고난과 역경을 헤치며 만들어가고 있는 ‘초고다움’, 그 초고다움을 말미암아 우리가 초고와 사랑에 빠질 수 밖에 없는 이유에 대해 초고의 김연지 대표와 이야기를 나눴어요.<title>[Interview] 우리가 함께 써내려간 초고를 돌아보며,</title><img>https://github.com/Indipage/ANDROID/assets/98076050/0fc510b2-8861-45ea-8222-002b929c873d</img><body><color><bold>Q. ‘술과 문학이 함께하는 공간’에서 출발했다고요. 책이 아니라 콕 집어 ‘문학’이었던 이유가 있을까요?</bold></color></body>사실 처음엔 <bold>책을 읽거나 글을 쓰거나 그런 창작 행위들을 편하게 할 수 있는 공간</bold>을 만들고 싶었던 것이 시작이었어요. <bold>술이 그것들을 좀 더 느슨하게,</bold> 용이하게 만든다는 생각을 했거든요. 그런 공간을 만든다고 생각했을 때, ‘초고’라는 이름이 잘 어울릴 것 같더라고요. 그런데 ‘초고’라는 이름이 뭔가 허전하다는 느낌이 들더라고요. 살롱처럼 어떤 행사나 모임을 할 수 있는 장이 되었으면 좋겠다는 생각에 ‘문학살롱’을 덧붙였어요. 사실 그때는 문학이나 문단 같은 거들에 대한 개념도 잘 몰랐어요. 그저 책=문학이라고 생각했죠. 그런데 그렇게 이름을 붙이게 되면서 점점 문학에 대해서 저도 함께 알아가게 됐어요."


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        viewModel.getArticleDetail(1)
        observe()
        setClickEventOnMoveToSpaceDetailTextView()
        setClickEventOnToolbar()
    }

    private fun setClickEventOnMoveToSpaceDetailTextView() {
        setArticleDetailAdapter()
        setClickEventOnMoveToSpaceDetailTextView()
        setClickEventOnToolbar()
        setClickEventOnTicketImage()
    }

    private fun setClickEventOnMoveToSpaceDetailTextView(){
        binding.tvArticleDetailMoveToPlaceDetail1.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_article_detail_to_space_detail)
        })
        binding.tvArticleDetailMoveToPlaceDetail2.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_article_detail_to_space_detail)
        })
    }

    private fun setClickEventOnToolbar() {
        binding.toolbarArticleDetail.setNavigationOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_article_detail_to_article)
        })
    }

    private fun observe() {
        viewModel.setAdapter.observe(viewLifecycleOwner) {
            val resultArticleArray = splitArticleBody(it.content)
            binding.rvArticleDetailArticleBody.adapter =
                ArticleDetailAdapter().apply { submitList(resultArticleArray) }
            Log.d("help", it.spaceOwner)
            binding.tvArticleDetailAuthor.text = it.spaceOwner
            binding.tvArticleDetailDate.text = it.createdAt
            binding.tvArticleDetailTitle.text = it.title
            binding.toolbarArticleDetail.title = it.spaceName
        }

        binding.ivArticleDetailBookmark.setOnClickListener(View.OnClickListener {
            toast("북마크")
        })
    }

    private fun setClickEventOnTicketImage(){
        binding.ivArticleDetailTicketImage.setOnClickListener(View.OnClickListener {
          snackBar(requireView(), message = { "티켓을 받았어요!" })
        })
    }

    private fun setArticleDetailAdapter() {
        // 주어진 문자열을 배열로 분할
        val resultArticleArray = splitArticleBody(testString)
        binding.rvArticleDetailArticleBody.adapter =
            ArticleDetailAdapter().apply { submitList(resultArticleArray) }
    }

    //전체 아티클 내용 태그 별 분할
    private fun splitArticleBody(input: String): List<ArticleDetailData> {

        var currentIndex = 0
        val articleList = listOf<ArticleDetailData>().toMutableList()

        TAG_REGEX.findAll(input).forEach { matchResult ->
            //정규식을 기반으로 각각 인풋에 대한 결과를 찾는다
            val tagLessPart = input.substring(currentIndex, matchResult.range.first)
            //태그가없는 부분에서 태그의 시작점까지 섭스트링에 인덱스번호로 찾음 그 부분 모드를 태그리스에 저장
            if (tagLessPart.isNotBlank()) {
                articleList.add(ArticleDetailData(tagLessPart))
            }
            //태그리스 부분이 비어있지않다면 배열의 추가
            articleList.add(ArticleDetailData(matchResult.value))
            currentIndex = matchResult.range.last + 1
        }

        val lastTagLessPart = input.substring(currentIndex)

        if (lastTagLessPart.isNotBlank()) {
            articleList.add(ArticleDetailData(lastTagLessPart))
        }

        return articleList
    }

    companion object {
        val TAG_REGEX = "(<img>.*?</img>|<title>.*?</title>|<body>.*?</body>)".toRegex()
    }


}