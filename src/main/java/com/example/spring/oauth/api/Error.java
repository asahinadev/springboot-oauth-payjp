package com.example.spring.oauth.api;

import java.util.HashMap;
import java.util.Map;

import com.example.spring.oauth.api.parameterized.SingleType;
import com.example.spring.oauth.api.values.ErrorType;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * �G���[���B
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY)
public class Error {

	public static final SingleType<Error> TYPE = new SingleType<>();

	/**
	 * TODO �����X�e�[�^�X.
	 * 
	 * 200 ���N�G�X�g����<br>
	 * 400 �s���ȃp�����[�^�[�Ȃǂ̃��N�G�X�g�G���[<br>
	 * 401 API�L�[�̔F�؃G���[<br>
	 * 402 �J�[�h�F�؁E�x�����G���[<br>
	 * 404 ���݂��Ȃ�API���\�[�X<br>
	 * 500 PAY.JP�⌈�σl�b�g���[�N�ł̏�Q<br>
	 */
	int status;

	/**
	 * �G���[�^�C�v.
	 */
	ErrorType type;

	/**
	 * TODO �G���[���b�Z�[�W.
	 * 
	 * invalid_number �s���ȃJ�[�h�ԍ�<br>
	 * invalid_cvc �s����CVC<br>
	 * invalid_expiration_date �s���ȗL�������N�A�܂��͌�<br>
	 * invalid_expiry_month �s���ȗL��������<br>
	 * invalid_expiry_year �s���ȗL�������N<br>
	 * expired_card �L�������؂�<br>
	 * card_declined �J�[�h��Ђɂ���ċ��ۂ��ꂽ�J�[�h<br>
	 * processing_error ���σl�b�g���[�N��Ő������G���[<br>
	 * missing_card �ڋq���J�[�h��ێ����Ă��Ȃ�<br>
	 * unacceptable_brand �Ώۂ̃J�[�h�u�����h��������Ă��Ȃ�<br>
	 * invalid_id �s����ID<br>
	 * no_api_key API�L�[���Z�b�g����Ă��Ȃ�<br>
	 * invalid_api_key �s����API�L�[<br>
	 * invalid_plan �s���ȃv����<br>
	 * invalid_expiry_days �s���Ȏ�������<br>
	 * unnecessary_expiry_days �����������s�v�ȃp�����[�^�[�ł���ꍇ<br>
	 * invalid_flexible_id �s����ID�w��<br>
	 * invalid_timestamp �s����Unix�^�C���X�^���v<br>
	 * invalid_trial_end �s���ȃg���C�A���I����<br>
	 * invalid_string_length �s���ȕ�����<br>
	 * invalid_country �s���ȍ����R�[�h<br>
	 * invalid_currency �s���Ȓʉ݃R�[�h<br>
	 * invalid_address_zip �s���ȗX�֔ԍ�<br>
	 * invalid_amount �s���Ȏx�������z<br>
	 * invalid_plan_amount �s���ȃv�������z<br>
	 * invalid_card �s���ȃJ�[�h<br>
	 * invalid_card_name �s���ȃJ�[�h�z���_�[��<br>
	 * invalid_card_country �s���ȃJ�[�h�����捑���R�[�h<br>
	 * invalid_card_address_zip �s���ȃJ�[�h������Z��(�X�֔ԍ�)<br>
	 * invalid_card_address_state �s���ȃJ�[�h������Z��(�s���{��)<br>
	 * invalid_card_address_city �s���ȃJ�[�h������Z��(�s�撬��)<br>
	 * invalid_card_address_line �s���ȃJ�[�h������Z��(�Ԓn�Ȃ�)<br>
	 * invalid_customer �s���Ȍڋq<br>
	 * invalid_boolean �s���Ș_���l<br>
	 * invalid_email �s���ȃ��[���A�h���X<br>
	 * no_allowed_param �p�����[�^�[��������Ă��Ȃ��ꍇ<br>
	 * no_param �p�����[�^�[�������Z�b�g����Ă��Ȃ�<br>
	 * invalid_querystring �s���ȃN�G���[������<br>
	 * missing_param �K�v�ȃp�����[�^�[���Z�b�g����Ă��Ȃ�<br>
	 * invalid_param_key �w��ł��Ȃ��s���ȃp�����[�^�[������<br>
	 * no_payment_method �x������i���Z�b�g����Ă��Ȃ�<br>
	 * payment_method_duplicate �x������i���d�����ăZ�b�g����Ă���<br>
	 * payment_method_duplicate_including_customer �x������i���d�����ăZ�b�g����Ă���(�ڋqID���܂�)<br>
	 * failed_payment �w�肵���x���������s���Ă���ꍇ<br>
	 * invalid_refund_amount �s���ȕԋ��z<br>
	 * already_refunded ���łɕԋ��ς�<br>
	 * invalid_amount_to_not_captured �m�肳��Ă��Ȃ��x�����ɑ΂��ĕ����ԋ����ł��Ȃ�<br>
	 * refund_amount_gt_net �ԋ��z�����̎x�����z���傫��<br>
	 * capture_amount_gt_net �x�����m��z�����̎x�����z���傫��<br>
	 * invalid_refund_reason �s���ȕԋ����R<br>
	 * already_captured ���łɎx�������m��ς�<br>
	 * cant_capture_refunded_charge �ԋ��ς݂̎x�����ɑ΂��Ďx�����m��͂ł��Ȃ�<br>
	 * cant_reauth_refunded_charge �ԋ��ς݂̎x�����ɑ΂��čĔF�؂͂ł��Ȃ�<br>
	 * charge_expired �F�؂��������Ă���x����<br>
	 * already_exist_id ���łɑ��݂��Ă���ID<br>
	 * token_already_used ���łɎg�p�ς݂̃g�[�N��<br>
	 * already_have_card �w�肵���ڋq�����łɕێ����Ă���J�[�h<br>
	 * dont_has_this_card �ڋq���w�肵���J�[�h��ێ����Ă��Ȃ�<br>
	 * doesnt_have_card �ڋq���J�[�h�������ێ����Ă��Ȃ�<br>
	 * already_have_the_same_card ���łɓ����J�[�h�ԍ��A�L�������̃J�[�h��ێ����Ă���<br>
	 * invalid_interval �s���ȉۋ�����<br>
	 * invalid_trial_days �s���ȃg���C�A������<br>
	 * invalid_billing_day �s���Ȏx�������s��<br>
	 * billing_day_for_non_monthly_plan �x�������s���͌����v�����ɂ����w��ł��Ȃ�<br>
	 * exist_subscribers �w���҂����݂���v�����͍폜�ł��Ȃ�<br>
	 * already_subscribed ���łɒ���ۋ��ς݂̌ڋq<br>
	 * already_canceled ���łɃL�����Z���ς݂̒���ۋ�<br>
	 * already_paused ���łɒ�~�ς݂̒���ۋ�<br>
	 * subscription_worked ���łɉғ����Ă������ۋ�<br>
	 * cannot_change_prorate_status ������ۋ��̐ݒ�̓v�����ύX���̂݉\<br>
	 * too_many_metadata_keys metadata�L�[�̓o�^���(20)�𒴉߂��Ă���<br>
	 * invalid_metadata_key �s����metadata�L�[<br>
	 * invalid_metadata_value �s����metadata�o�����[<br>
	 * apple_pay_disabled_in_livemode �{�ԃ��[�h��Apple Pay���p��������Ă��Ȃ�<br>
	 * invalid_apple_pay_token �s����Apple Pay�g�[�N��<br>
	 * test_card_on_livemode �{�ԃ��[�h�̃��N�G�X�g�Ƀe�X�g�J�[�h���g�p����Ă���<br>
	 * not_activated_account �{�ԃ��[�h��������Ă��Ȃ��A�J�E���g<br>
	 * too_many_test_request �e�X�g���[�h�̃��N�G�X�g���~�b�g�𒴉߂��Ă���<br>
	 * payjp_wrong PAY.JP�̃T�[�o�[���ŃG���[���������Ă���<br>
	 * pg_wrong ���ϑ�s��Ђ̃T�[�o�[���ŃG���[���������Ă���<br>
	 * not_found ���N�G�X�g�悪���݂��Ȃ����Ƃ�����<br>
	 * not_allowed_method ������Ă��Ȃ�HTTP���\�b�h<br>
	 */
	String message;

	/** ���^�f�[�^�B */
	@JsonProperty("metadata")
	Map<String, Object> metadata = new HashMap<>();

	/** ���̑����B */
	@JsonAnySetter
	Map<String, Object> attributes = new HashMap<>();
}
